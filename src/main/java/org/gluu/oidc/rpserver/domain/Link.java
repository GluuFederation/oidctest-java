package org.gluu.oidc.rpserver.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="links")
public class Link {
    @Id
    public String id;
    
    private String name;
	private String url;
	private String code;

	public Link() { }
	
	public Link(String name, String url, String code) {
		this.name = name;
		this.url = url;
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Link [id=" + id + ", name=" + name + ", url=" + url + ", code=" + code + "]";
	}	
}
