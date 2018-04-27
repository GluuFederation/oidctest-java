package org.gluu.oidc.rpserver.service.impl;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Url;
import org.gluu.oidc.rpserver.repository.UrlRepository;
import org.gluu.oidc.rpserver.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {
	@Autowired
	private UrlRepository urlRepository;
	
	@Override
	public List<Url> findAll() {
		return urlRepository.findAll();
	}

}
