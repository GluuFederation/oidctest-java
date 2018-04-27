package org.gluu.oidc.rpserver.service;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Group;

public interface GroupService {
	public List<Group> findAll();
}
