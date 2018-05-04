package org.gluu.oidc.rpserver.controller;

import org.gluu.oidc.rpserver.domain.TestList;
import org.gluu.oidc.rpserver.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestListController extends BaseController {
	@Autowired
	private TestService testService;
	
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String showTests(@RequestParam("profile") String profile, Model model) {
    	TestList testList = testService.getTestList(profile);
    	model.addAttribute("testList", testList);

        return "tests";
    }
}
