package org.gluu.oidc.rpserver.repository;

import org.gluu.oidc.rpserver.domain.Link;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends MongoRepository<Link, String> {


}

