package org.gluu.oidc.rpserver.service.impl;

import java.util.List;

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

}