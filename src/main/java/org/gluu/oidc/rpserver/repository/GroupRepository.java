package org.gluu.oidc.rpserver.repository;

import org.gluu.oidc.rpserver.domain.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends MongoRepository<Group, String> {


}

