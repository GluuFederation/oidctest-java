package org.gluu.oidc.rpserver.controller;

import org.gluu.oidc.rpserver.domain.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class BaseController {
	@Value("${app.version}")
	private String appVersion;
	@Value("${app.email}")	
	private String email;
	@Value("${app.copyright}")	
	private String copyright;
	@Value("${app.org.name}")	
	private String orgName;
	@Value("${app.org.url}")	
	private String orgUrl;
	@Value("${app.issues.host.name}")	
	private String issuesHostName;
	@Value("${app.issues.host.url}")	
	private String issuesHostUrl;
	@Value("${app.emailTo}")	
	private String emailTo;	
	
	@ModelAttribute("info")
	public Info getAppVersion() {
		Info appInfo = new Info();
		appInfo.setAppVersion(appVersion);
		appInfo.setCopyright(copyright);
		appInfo.setEmail(email);
		appInfo.setIssuesHostName(issuesHostName);
		appInfo.setIssuesHostUrl(issuesHostUrl);
		appInfo.setOrgName(orgName);
		appInfo.setOrgUrl(orgUrl);
		appInfo.setEmailTo(emailTo);
		
		return appInfo;
	}
}
