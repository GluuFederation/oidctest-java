package org.gluu.oidc.rpserver.service.impl;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Profile;
import org.gluu.oidc.rpserver.repository.ProfileRepository;
import org.gluu.oidc.rpserver.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public List<Profile> findAll() {
		return profileRepository.findAll();
	}

}
