package org.gluu.oidc.rpserver.service.impl;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Group;
import org.gluu.oidc.rpserver.repository.GroupRepository;
import org.gluu.oidc.rpserver.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
	@Autowired
	private GroupRepository groupRepository;
	
	@Override
	public List<Group> findAll() {
		return groupRepository.findAll();	
	}

}