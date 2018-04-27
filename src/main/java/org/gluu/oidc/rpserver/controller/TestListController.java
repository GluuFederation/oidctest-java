package org.gluu.oidc.rpserver.controller;

import org.gluu.oidc.rpserver.domain.TestList;
import org.gluu.oidc.rpserver.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestListController {
	@Autowired
	private TestService testService;
	
    @RequestMapping(path = "/tests", method = RequestMethod.GET)
    public String showTests(Model model) {
    	TestList testList = testService.getTestList();
    	
        return "tests";
    }
}
