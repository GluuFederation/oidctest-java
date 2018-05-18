package org.gluu.oidc.rpserver.service;

import org.gluu.oidc.rpserver.domain.Configuration;

public interface ConfigurationService {	
	public Configuration findConfigurationByName(String name);
}
