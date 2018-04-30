package org.gluu.oidc.rpserver.repository;

import java.util.List;

import org.gluu.oidc.rpserver.domain.Flow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowRepository extends MongoRepository<Flow, String> {
	@Query("{ 'name' : {$regex : 'rp-*'} }")
	public List<Flow> findRPFlows();

}

