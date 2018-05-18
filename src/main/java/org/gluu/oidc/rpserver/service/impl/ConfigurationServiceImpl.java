package org.gluu.oidc.rpserver.service.impl;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Configuration;
import org.gluu.oidc.rpserver.repository.ConfigurationRepository;
import org.gluu.oidc.rpserver.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {
	@Autowired
	private ConfigurationRepository configurationRepository;

	@Override
	public Configuration findConfigurationByName(String name) {
		List<Configuration> configurations = configurationRepository.findByName(name);
		if(configurations != null) {
			return configurations.get(0);
		}
		return null;
	}	

}