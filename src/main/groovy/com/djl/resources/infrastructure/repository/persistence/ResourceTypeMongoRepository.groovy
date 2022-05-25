package com.djl.resources.infrastructure.repository.persistence


import com.djl.resources.infrastructure.data.model.ResourceTypeDocument
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ResourceTypeMongoRepository extends MongoRepository<ResourceTypeDocument, ObjectId> {

    @Query("{'enabled': true}")
    List<ResourceTypeDocument> findAllEnabled()

}