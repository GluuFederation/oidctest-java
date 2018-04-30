package org.gluu.oidc.rpserver.service;

import org.gluu.oidc.rpserver.domain.TestList;

public interface TestService {
	public TestList getTestList(String profile);
}
