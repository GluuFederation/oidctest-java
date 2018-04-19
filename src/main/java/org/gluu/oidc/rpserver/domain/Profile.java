package org.gluu.oidc.rpserver.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="profiles")
public class Profile {
    @Id
    public String id;
    
	private String code;
	private String name;
	private String description;
	
	public Profile() { }

	public Profile(String code, String name, String description) {
		this.code = code;
		this.name = name;
		this.description = description;
	}
	
	public String getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + "]";
	}

}
