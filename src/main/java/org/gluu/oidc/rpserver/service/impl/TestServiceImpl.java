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
import org.gluu.oidc.rpserver.service.ProfileService;
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
	@Autowired
	private ProfileService profileService;
	
	private final Pattern PAT = Pattern.compile("\\$\\{([A-Z_0-9]*)\\}");
	
	@Override
	public TestList getTestList(String profile) {
		TestList testList = new TestList();
		
		List<Link> links = linkService.findAll();
		List<Url> urls = urlService.findAll();
		List<Group> groups = groupService.findAll();
		Map<String, Abbreviation> abbreviations = abbreviationService.getAbbreviations();
		
		List<Flow> flows = flowService.findRPFlows(); 
		System.out.println("Flows size " + flows.size());
		
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
				System.out.println("created mandatory test: " + test);
				mandatoryTests.add(test);
			} else { // optional
				List<String> responseTypes = flow.getCapabilities().get("response_types_supported");
				Map<String, String> flowProfiles = getFlowProfiles(responseTypes, abbreviations);

				//System.out.println("flow profiles = " + flowProfiles);
				//System.out.println("target profile = " + profile);
				if(flowProfiles.get(profile) != null) {
					String name = flow.getName();
					String detailedDescr = replaceWithLink(flow.getDetailedDescription(), links, urls);
					String expectedResult = replaceWithLink(flow.getExpectedResult(), links, urls);
					String group = flow.getGroup();
					Test test = new Test(name, detailedDescr, expectedResult, group);	
					System.out.println("created optional test: " + test);
					optionalTests.add(test);					
				}
			}
		});			
		
    	System.out.println("Profile " + profile + " has " + 
    			mandatoryTests.size() + " mandatory AND " + 
				optionalTests.size() + " optional tests" );
    	
    	// group tests per group
    	System.out.println("Processing mandatory:");
    	Map<String, List<Test>> mandatoryItems = this.groupTests(mandatoryTests, groups);
    	System.out.println("Processing optional:");
    	Map<String, List<Test>> optionalItems = this.groupTests(optionalTests, groups);
    	testList.setMandatoryTests(mandatoryItems);
    	testList.setOptionalTests(optionalItems);
    	
    	// constructing the header
    	String profileName = abbreviationService.getAbbreviationByProfile(profile); 
    	String header = String.format("List of OIDC RP library tests for profile: \"<i>%s</i>\"", profileName);
    	System.out.println("header=" + header);
    	testList.setHeader(header);
    	
    //	System.out.println("testList=" + testList);
		return testList;
	}
	
	/*
	  else:
                    try:
                        rts = _info["capabilities"]["response_types_supported"]
                    except KeyError:
                        pass
                    else:
                        profs = [ABBR[x] for x in rts]
                        if profile in profs:
                            _det_desc = replace_with_link(
                                _info['detailed_description'], self.links)
                            _exp_res = replace_with_link(
                                _info['expected_result'], self.links)
                            optional.append((fn[:-5], _det_desc, _exp_res,
                                             _info['group']))
	 */
	
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
	
	
	/*
	 def test_list(args, grps):
    """
    Creates list of test descriptions
    """
    line = ['<table class="tab`

ble-bordered table-condensed">',
        '<tr><th>Test ID</th><th>Description</th><th>Info2</th></tr>']

    for pgrp in grps:
        h = False
        for tid, desc, result, grp in args:
            if pgrp == grp:
                if h is False:
                    line.append(
                        '<tr style><td colspan="3" class="text-center info"><b>{}</b></td></tr>'.format(grp))
                    h = True

                line.append(
                    '<tr><tH style="white-space:nowrap">{}</tH><td>{}</td><td>{}</td></tr>'.format(
                        tid, desc, result))
    line.append('</table>')
    return line
	 */
	
	private Map<String, List<Test>> groupTests(final List<Test> tests, final List<Group> groups) {
		Map<String, List<Test>> results = new HashMap<String, List<Test>>();
		if(groups != null) {
			for(Group grp : groups) {
				for(Test test : tests) {
				//	System.out.println("rp.getName()=" + grp.getName() + ", test.getGroup() = "  + test.getGroup()+ " - result:" + grp.getName().equals(test.getGroup()));
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
	
	/*
	 def replace_with_link(txt, links):
    for m in PAT.findall(txt):
        try:
            _url, tag = links['LINK'][m]
        except KeyError:
            pass
        else:
            _li = replace_with_url(_url, links)
            _href = '<a href="{}">{}</a>'.format(_li, tag)
            txt = txt.replace('${%s}' % m, _href)
    return txt
	 */

	private String replaceWithLink(String str, final List<Link> links, final List<Url> urls) {
		Matcher regexMatcher = PAT.matcher(str);
		while(regexMatcher.find()) {
			String phName = regexMatcher.group(1);
			for(Link link : links) {
				//System.out.println("group=" + phName + ", name=" + link.getName());
				if(link.getName().equals(phName)) {
					String li = replaceWithUrl(link.getUrl(), urls);
					String href = String.format("<a href=\"%s\">%s</a>", li, link.getCode());
					str = str.replace(String.format("${%s}", phName), href);
				}
			}
		}
		return str;
	}
	
	
	/*
	 def replace_with_url(txt, links):
    for m in PAT.findall(txt):
        try:
            _url = links['URL'][m]
        except KeyError:
            pass
        else:
            txt = txt.replace('${%s}' % m, _url)

    return txt
	 */
	
	private String replaceWithUrl(String str, final List<Url> urls) {
		Matcher regexMatcher = PAT.matcher(str);
		while(regexMatcher.find()) {
			String phName = regexMatcher.group(1);
			for(Url url : urls) {
				//System.out.println("group=" + phName + ", name=" + url.getName());
				if(url.getName().equals(phName)) {
					str = str.replace(String.format("${%s}", phName), url.getUrl());
				}
			}
		}
		return str;
	}	
}