package com.djl.resources.domain.repository

import com.djl.resources.domain.data.model.ResourceType

interface ResourceTypeRepository {

    Optional<ResourceType> create(ResourceType resourceType)

    List<ResourceType> findAllEnabled()

    Optional<ResourceType> findById(String id)

    Optional<ResourceType> delete(String id)

    Optional<ResourceType> update(String id, ResourceType resourceType)

    Optional<ResourceType> patch(String id, ResourceType resourceType)

}
