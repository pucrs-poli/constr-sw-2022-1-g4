package com.djl.resources.infrastructure.repository.persistence


import com.djl.resources.infrastructure.data.model.ResourceDocument
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Component

@Component
interface ResourceMongoRepository extends MongoRepository<ResourceDocument, ObjectId> {

    @Query("{ 'enabled': true }")
    List<ResourceDocument> findAllEnabled();

    List<ResourceDocument> findAllByAttributes();

}