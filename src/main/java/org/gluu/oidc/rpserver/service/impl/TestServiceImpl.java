package org.gluu.oidc.rpserver.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.gluu.oidc.rpserver.domain.Abbreviation;
import org.gluu.oidc.rpserver.domain.Flow;
import org.gluu.oidc.rpserver.domain.Group;
import org.gluu.oidc.rpserver.domain.Link;
import org.gluu.oidc.rpserver.domain.Test;
import org.gluu.oidc.rpserver.domain.TestList;
import org.gluu.oidc.rpserver.domain.Url;
import org.gluu.oidc.rpserver.service.AbbreviationService;
import org.gluu.oidc.rpserver.service.FlowService;
import org.gluu.oidc.rpserver.service.GroupService;
import org.gluu.oidc.rpserver.service.LinkService;
import org.gluu.oidc.rpserver.service.TestService;
import org.gluu.oidc.rpserver.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private LinkService linkService;
	@Autowired
	private UrlService urlService;
	@Autowired
	private AbbreviationService abbreviationService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private FlowService flowService;
	
	private final Pattern PAT = Pattern.compile("\\$\\{([A-Z_0-9]*)\\}");
	
	@Override
	public TestList getTestList(String profile) {
		TestList testList = new TestList();
		
		List<Link> links = linkService.findAll();
		List<Url> urls = urlService.findAll();
		List<Group> groups = groupService.findAll();
		Map<String, Abbreviation> abbreviations = abbreviationService.getAbbreviations();
		
		List<Flow> flows = flowService.findRPFlows(); 

		List<Test> mandatoryTests = new ArrayList<Test>();
		List<Test> optionalTests = new ArrayList<Test>();
		
		flows.stream().forEach(flow -> {
			List<String> mtiItems = flow.getMtiItems();
			if(mtiItems != null && mtiItems.contains(profile)) { // if it has MTI items it belongs to mandatory tests
				String name = flow.getName();
				String detailedDescr = replaceWithLink(flow.getDetailedDescription(), links, urls);
				String expectedResult = replaceWithLink(flow.getExpectedResult(), links, urls);
				String group = flow.getGroup();
				Test test = new Test(name, detailedDescr, expectedResult, group);
				mandatoryTests.add(test);
			} else { // optional
				List<String> responseTypes = flow.getCapabilities().get("response_types_supported");
				Map<String, String> flowProfiles = getFlowProfiles(responseTypes, abbreviations);

				if(flowProfiles.get(profile) != null) {
					String name = flow.getName();
					String detailedDescr = replaceWithLink(flow.getDetailedDescription(), links, urls);
					String expectedResult = replaceWithLink(flow.getExpectedResult(), links, urls);
					String group = flow.getGroup();
					Test test = new Test(name, detailedDescr, expectedResult, group);	
					optionalTests.add(test);					
				}
			}
		});			
		
    	// group tests per group
    	Map<String, List<Test>> mandatoryItems = this.groupTests(mandatoryTests, groups);
    	Map<String, List<Test>> optionalItems = this.groupTests(optionalTests, groups);
    	testList.setMandatoryTests(mandatoryItems);
    	testList.setOptionalTests(optionalItems);
    	
    	// constructing the header
    	String profileName = abbreviationService.getAbbreviationByProfile(profile); 
    	String header = String.format("List of OIDC RP library tests for profile: \"<i>%s</i>\"", profileName);
    	testList.setHeader(header);
    	
		return testList;
	}
	
	private Map<String, String> getFlowProfiles(final List<String> responseTypes, 
			final Map<String, Abbreviation> abbreviations) {
		Map<String, String> profiles = new HashMap<String, String>();
		if(responseTypes != null) {
			for(String rp : responseTypes) {
				Abbreviation abbr = abbreviations.get(rp);
				profiles.put(abbr.getCode(), abbr.getName());
			}
		}
		
		return profiles;
	}

	private Map<String, List<Test>> groupTests(final List<Test> tests, final List<Group> groups) {
		Map<String, List<Test>> results = new HashMap<String, List<Test>>();
		if(groups != null) {
			for(Group grp : groups) {
				for(Test test : tests) {
					if(grp.getName().equals(test.getGroup())) {
						List<Test> grpTests = results.get(grp.getName());
						if(grpTests == null) { 
							grpTests = new ArrayList<Test>();
							grpTests.add(test);
							
							results.put(grp.getName(), grpTests);
						} else {
							grpTests.add(test);
						}
					}
				}
			}
		}
		
		return results;
	}
	
	private String replaceWithLink(String str, final List<Link> links, final List<Url> urls) {
		Matcher regexMatcher = PAT.matcher(str);
		while(regexMatcher.find()) {
			String phName = regexMatcher.group(1);
			for(Link link : links) {
				if(link.getName().equals(phName)) {
					String li = replaceWithUrl(link.getUrl(), urls);
					String href = String.format("<a href=\"%s\">%s</a>", li, link.getCode());
					str = str.replace(String.format("${%s}", phName), href);
				}
			}
		}
		return str;
	}
	
	private String replaceWithUrl(String str, final List<Url> urls) {
		Matcher regexMatcher = PAT.matcher(str);
		while(regexMatcher.find()) {
			String phName = regexMatcher.group(1);
			for(Url url : urls) {
				if(url.getName().equals(phName)) {
					str = str.replace(String.format("${%s}", phName), url.getUrl());
				}
			}
		}
		return str;
	}	
}