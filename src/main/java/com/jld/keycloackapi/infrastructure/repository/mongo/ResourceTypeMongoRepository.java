package com.jld.keycloackapi.infrastructure.repository.mongo;

import com.jld.keycloackapi.infrastructure.data.model.document.ResourceTypeDocument;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceTypeMongoRepository extends CrudRepository<ResourceTypeDocument, ObjectId> {

}
