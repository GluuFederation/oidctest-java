package org.gluu.oidc.rpserver.domain;

public class Test {
	private String testID;
	private String description;
	private String info;
	private String group;
	
	public Test() { }
	
	public Test(String testID, String description, String info, String group) {
		this.testID = testID;
		this.description = description;
		this.info = info;
		this.group = group;
	}
	
	public String getTestID() {
		return testID;
	}
	
	public void setTestID(String testID) {
		this.testID = testID;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Test [testID=" + testID + ", description=" + description + ", info=" + info + ", group=" + group + "]";
	}
	
}
