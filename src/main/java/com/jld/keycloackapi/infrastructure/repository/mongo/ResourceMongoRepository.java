package com.jld.keycloackapi.infrastructure.repository.mongo;

import com.jld.keycloackapi.infrastructure.data.model.document.ResourceDocument;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceMongoRepository extends CrudRepository<ResourceDocument, ObjectId> {

}
