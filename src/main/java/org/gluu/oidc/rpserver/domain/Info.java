package org.gluu.oidc.rpserver.domain;

public class Info {
	private String appVersion;
	private String email;
	private String copyright;
	private String orgName;
	private String orgUrl;
	private String issuesHostName;
	private String issuesHostUrl;
	private String emailTo;
	
	public Info() {
	}
	
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgUrl() {
		return orgUrl;
	}
	public void setOrgUrl(String orgUrl) {
		this.orgUrl = orgUrl;
	}
	public String getIssuesHostName() {
		return issuesHostName;
	}
	public void setIssuesHostName(String issuesHostName) {
		this.issuesHostName = issuesHostName;
	}
	public String getIssuesHostUrl() {
		return issuesHostUrl;
	}
	public void setIssuesHostUrl(String issuesHostUrl) {
		this.issuesHostUrl = issuesHostUrl;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	@Override
	public String toString() {
		return "Info [appVersion=" + appVersion + ", email=" + email + ", copyright=" + copyright + ", orgName="
				+ orgName + ", orgUrl=" + orgUrl + ", issuesHostName=" + issuesHostName + ", issuesHostUrl="
				+ issuesHostUrl + ", emailTo=" + emailTo + "]";
	}
	
}
