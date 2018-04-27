package org.gluu.oidc.rpserver.controller;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Profile;
import org.gluu.oidc.rpserver.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
    @RequestMapping(path = {"/", "/home"}, method = RequestMethod.GET)
    public String showProfiles(Model model) {
    	List<Profile> profiles = profileService.findAll();
    	model.addAttribute("profiles", profiles);
    	
        return "profiles";
    }	
}
