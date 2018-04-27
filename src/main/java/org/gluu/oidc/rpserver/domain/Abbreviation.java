package org.gluu.oidc.rpserver.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="abbrs")
public class Abbreviation {
    @Id
    public String id;
    
    private String name;
    private String code;
    
	public Abbreviation() { }
	
	public Abbreviation(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Abbreviation [id=" + id + ", name=" + name + ", code=" + code + "]";
	}    

	
}
