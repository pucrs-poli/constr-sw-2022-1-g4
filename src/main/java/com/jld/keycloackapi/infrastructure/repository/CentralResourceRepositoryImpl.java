package com.jld.keycloackapi.infrastructure.repository;

import com.jld.keycloackapi.domain.repository.CentralResourceRepository;
import com.jld.keycloackapi.infrastructure.repository.mongo.ResourceMongoRepository;
import com.jld.keycloackapi.infrastructure.repository.mongo.ResourceTypeMongoRepository;
import org.springframework.stereotype.Component;

@Component
public class CentralResourceRepositoryImpl implements CentralResourceRepository {

	private final ResourceMongoRepository resourceMongoRepository;
	private final ResourceTypeMongoRepository resourceTypeMongoRepository;

	public CentralResourceRepositoryImpl(
		final ResourceMongoRepository resourceMongoRepository,
		final ResourceTypeMongoRepository resourceTypeMongoRepository) {
		this.resourceMongoRepository = resourceMongoRepository;
		this.resourceTypeMongoRepository = resourceTypeMongoRepository;
	}
}
