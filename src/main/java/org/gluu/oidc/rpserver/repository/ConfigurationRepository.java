package org.gluu.oidc.rpserver.repository;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends MongoRepository<Configuration, String> {
	@Query("{ 'name' : ?0 }")
	public List<Configuration> findByName(String name);
}

