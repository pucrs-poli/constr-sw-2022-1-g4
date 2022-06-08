package com.djl.resources.infrastructure.repository.persistence


import com.djl.resources.infrastructure.data.model.ResourceDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ResourceMongoRepository extends MongoRepository<ResourceDocument, String> {

    @Query("{ 'enabled': true }")
    List<ResourceDocument> findAllEnabled();

    @Query("{ 'name': ?0 }")
    Optional<ResourceDocument> findByName(String name);

    @Query("{ ?0 }")
    List<ResourceDocument> findByQuery(String query);

    @Query("{ 'resourceTypeIdentification': ?0 }")
    List<ResourceDocument> findByResourceTypeIdentification(String resourceTypeIdentification)


}