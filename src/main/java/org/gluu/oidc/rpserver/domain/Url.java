package org.gluu.oidc.rpserver.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="urls")
public class Url {
    @Id
    public String id;
    
	private String url;
	private String name;
	
	public Url() { }
	
	public Url(String url, String name) {
		this.url = url;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UrlItem [id=" + id + ", url=" + url + ", name=" + name + "]";
	}	
}
