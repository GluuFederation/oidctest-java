package org.gluu.oidc.rpserver.domain;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="flows")
public class Flow {
    @Id
    public String id;
    
	private String name;
    @Field("mti")
	private List<String> mtiItems;
	private String group;
	private List<String> behaviours; 
	private String claims;	
	private Map<String, List<String>> capabilities; 
    @Field("short_description")	
	private String shortDescription;	
    @Field("detailed_description")
	private String detailedDescription;	
    @Field("expected_result")
	private String expectedResult;

	public Flow() { }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public List<String> getMtiItems() {
		return mtiItems;
	}
	
	public void setMtiItems(List<String> mtiItems) {
		this.mtiItems = mtiItems;
	}
	
	public String getGroup() {
		return group;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}
	
	public List<String> getBehaviours() {
		return behaviours;
	}
	
	public void setBehaviours(List<String> behaviours) {
		this.behaviours = behaviours;
	}
	
	public String getClaims() {
		return claims;
	}
	
	public void setClaims(String claims) {
		this.claims = claims;
	}
	
	public Map<String, List<String>> getCapabilities() {
		return capabilities;
	}
	
	public void setCapabilities(Map<String, List<String>> capabilities) {
		this.capabilities = capabilities;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	public String getDetailedDescription() {
		return detailedDescription;
	}
	
	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}
	
	public String getExpectedResult() {
		return expectedResult;
	}
	
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}

	@Override
	public String toString() {
		return "Flow [id=" + id + ", name=" + name + ", mtiItems=" + mtiItems + ", group=" + group + ", behaviours="
				+ behaviours + ", claims=" + claims + ", capabilities=" + capabilities + ", shortDescription="
				+ shortDescription + ", detailedDescription=" + detailedDescription + ", expectedResult="
				+ expectedResult + "]";
	}

}
