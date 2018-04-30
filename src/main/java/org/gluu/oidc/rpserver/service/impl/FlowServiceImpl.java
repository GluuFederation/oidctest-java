package org.gluu.oidc.rpserver.service.impl;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Flow;
import org.gluu.oidc.rpserver.repository.FlowRepository;
import org.gluu.oidc.rpserver.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowServiceImpl implements FlowService {
	@Autowired
	private FlowRepository flowRepository;
	
	@Override
	public List<Flow> findRPFlows() {
		return flowRepository.findRPFlows();
	}

}