package org.gluu.oidc.rpserver.service;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Profile;

public interface ProfileService {
	public List<Profile> findAll();
}
