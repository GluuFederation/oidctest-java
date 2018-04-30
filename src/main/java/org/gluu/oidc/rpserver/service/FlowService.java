package org.gluu.oidc.rpserver.service;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Flow;

public interface FlowService {
	public List<Flow> findRPFlows();
}
