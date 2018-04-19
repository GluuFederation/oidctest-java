package org.gluu.oidc.rpserver.repository;

import org.gluu.oidc.rpserver.domain.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {


}
