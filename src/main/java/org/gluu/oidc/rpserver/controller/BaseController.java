package org.gluu.oidc.rpserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class BaseController {
	@Value("${app.version}")
	private String appVersion;
	
	@ModelAttribute("appVersion")
	public String getAppVersion() {
		return appVersion;
	}
}
