package org.gluu.oidc.rpserver.repository;

import org.gluu.oidc.rpserver.domain.Abbreviation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbbreviationRepository extends MongoRepository<Abbreviation, String> {


}

