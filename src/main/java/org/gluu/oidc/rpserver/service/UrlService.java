package org.gluu.oidc.rpserver.service;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Url;

public interface UrlService {
	public List<Url> findAll();
}
