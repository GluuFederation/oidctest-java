package org.gluu.oidc.rpserver.repository;

import org.gluu.oidc.rpserver.domain.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<Url, String> {


}
