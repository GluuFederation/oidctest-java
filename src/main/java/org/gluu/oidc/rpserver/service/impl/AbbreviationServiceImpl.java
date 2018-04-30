package org.gluu.oidc.rpserver.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.gluu.oidc.rpserver.domain.Abbreviation;
import org.gluu.oidc.rpserver.repository.AbbreviationRepository;
import org.gluu.oidc.rpserver.service.AbbreviationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbbreviationServiceImpl implements AbbreviationService {
	@Autowired
	private AbbreviationRepository abbreviationRepository;
	
	@Override
	public List<Abbreviation> findAll() {
		return abbreviationRepository.findAll();
	}

	@Override
	public Map<String, Abbreviation> getAbbreviations() {
		List<Abbreviation> abbrs = findAll();
		Map<String, Abbreviation> map = abbrs.stream()
				.collect(Collectors.toMap(a -> a.getName(), a -> a));
		
		return map;
	}

	@Override
	public String getAbbreviationByProfile(String profile) {
		List<Abbreviation> abbrs = findAll();
		if(abbrs != null) {
			for(Abbreviation ab : abbrs) {
				if(ab.getCode().equals(profile)) {
					return ab.getName();
				}
			}
		}
		return "";
	}	
}