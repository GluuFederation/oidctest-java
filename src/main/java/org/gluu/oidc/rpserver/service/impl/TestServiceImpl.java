package org.gluu.oidc.rpserver.service.impl;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Flow;
import org.gluu.oidc.rpserver.domain.TestList;
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
	
	@Override
	public TestList getTestList() {
		TestList testList = new TestList();
		
		List<Flow> flows = flowService.findAll();
		if(flows != null) {
			System.out.println("Flows size " + flows.size());
		} else {
			System.out.println("Flows is empty");
		}
		flows.stream().forEach(System.out::println);
			
		return testList;
	}

}