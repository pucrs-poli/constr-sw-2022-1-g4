package com.djl.resources.domain.repository

import com.djl.resources.domain.data.model.Resource

interface ResourceRepository {

    Optional<Resource> create(Resource resource)

    List<Resource> findAll()

    Optional<Resource> findById(String id)

    List<Resource> findByAttribute(String query)

    Optional<Resource> delete(String id)

    Optional<Resource> update(String id, Resource resource)

    Optional<Resource> patch(String id, Resource resource)

}