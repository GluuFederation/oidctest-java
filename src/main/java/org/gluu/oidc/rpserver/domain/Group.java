package org.gluu.oidc.rpserver.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="groups")
public class Group {
    @Id
    public String id;
    
    private String name;

	public Group() { }

	public Group(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	} 
}
