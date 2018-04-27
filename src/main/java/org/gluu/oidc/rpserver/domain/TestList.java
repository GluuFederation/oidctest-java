package org.gluu.oidc.rpserver.domain;

import java.util.List;
import java.util.Map;

public class TestList {
	private Map<String, List<Test>> mandatoryTests;
	private Map<String, List<Test>> optionalTests;

	public TestList() {}

	public TestList(Map<String, List<Test>> mandatoryTests, Map<String, List<Test>> optionalTests) {
		this.mandatoryTests = mandatoryTests;
		this.optionalTests = optionalTests;
	}
	
	public Map<String, List<Test>> getMandatoryTests() {
		return mandatoryTests;
	}
	
	public void setMandatoryTests(Map<String, List<Test>> mandatoryTests) {
		this.mandatoryTests = mandatoryTests;
	}
	
	public Map<String, List<Test>> getOptionalTests() {
		return optionalTests;
	}
	
	public void setOptionalTests(Map<String, List<Test>> optionalTests) {
		this.optionalTests = optionalTests;
	}

	@Override
	public String toString() {
		return "TestList [mandatoryTests=" + mandatoryTests + ", optionalTests=" + optionalTests + "]";
	}	
	
	
}
