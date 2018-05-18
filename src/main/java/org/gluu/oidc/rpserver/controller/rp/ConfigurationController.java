package org.gluu.oidc.rpserver.controller.rp;

import javax.servlet.http.HttpServletResponse;

import org.gluu.oidc.rpserver.domain.Configuration;
import org.gluu.oidc.rpserver.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigurationController {
	@Autowired
	private ConfigurationService configurationService;
	
	@Value("${server.url}")
	private String serverUrl;
	@Value("${server.port}")	
	private int serverPort;
	
    @RequestMapping(path = "{client_id}/{test_id}/.well-known/openid-configuration", method = RequestMethod.GET)
    public @ResponseBody Configuration deliverConfiguration(
    		@PathVariable("client_id") String clientId,
    		@PathVariable("test_id") String testId,
    		HttpServletResponse response) throws CloneNotSupportedException {
    	Configuration configuration = configurationService.findConfigurationByName("welcome");
    	
    	configuration.setServerUrl(String.format("%s:%d",serverUrl, serverPort));
    	configuration.setClientId(clientId);
    	configuration.setTestId(testId);

    	return (Configuration)configuration.clone();
    }
}
