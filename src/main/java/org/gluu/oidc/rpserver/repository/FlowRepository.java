package org.gluu.oidc.rpserver.repository;

import org.gluu.oidc.rpserver.domain.Flow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowRepository extends MongoRepository<Flow, String> {


}

