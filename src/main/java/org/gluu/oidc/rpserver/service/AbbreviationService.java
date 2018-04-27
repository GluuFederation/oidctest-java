package org.gluu.oidc.rpserver.service;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Abbreviation;

public interface AbbreviationService {
	public List<Abbreviation> findAll();
}
