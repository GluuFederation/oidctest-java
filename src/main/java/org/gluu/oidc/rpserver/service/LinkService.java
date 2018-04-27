package org.gluu.oidc.rpserver.service;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Link;

public interface LinkService {
	public List<Link> findAll();
}
