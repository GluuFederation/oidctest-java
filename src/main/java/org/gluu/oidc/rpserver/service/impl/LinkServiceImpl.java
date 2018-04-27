package org.gluu.oidc.rpserver.service.impl;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Link;
import org.gluu.oidc.rpserver.repository.LinkRepository;
import org.gluu.oidc.rpserver.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService {
	@Autowired
	private LinkRepository linkRepository;
	
	@Override
	public List<Link> findAll() {
		return linkRepository.findAll();
	}

}