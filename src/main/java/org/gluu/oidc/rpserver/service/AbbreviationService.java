package org.gluu.oidc.rpserver.service;

import java.util.List;
import java.util.Map;

import org.gluu.oidc.rpserver.domain.Abbreviation;

public interface AbbreviationService {
	public List<Abbreviation> findAll();
	public Map<String, Abbreviation> getAbbreviations();	
	public String getAbbreviationByProfile(String profile);
}
