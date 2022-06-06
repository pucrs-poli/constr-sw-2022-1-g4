package com.djl.resources.infrastructure.repository

import com.djl.resources.domain.data.model.Resource
import com.djl.resources.domain.repository.ResourceRepository
import com.djl.resources.infrastructure.data.mapper.ResourceMapper
import com.djl.resources.infrastructure.data.model.ResourceDocument
import com.djl.resources.infrastructure.repository.persistence.ResourceMongoRepository
import org.springframework.data.mongodb.core.query.Query
import org.bson.types.ObjectId
import org.springframework.stereotype.Component

@Component
class ResourceRepositoryImpl implements ResourceRepository {

    ResourceMongoRepository mongoRepository

    ResourceMapper mapper

    ResourceRepositoryImpl(ResourceMongoRepository mongoRepository, ResourceMapper mapper) {
        this.mongoRepository = mongoRepository
        this.mapper = mapper
    }

    @Override
    Optional<Resource> create(Resource resource) {
        if (mongoRepository.existsById(new ObjectId(resource.getId())) || mongoRepository.findByName(resource.getName()).isPresent())
            return Optional.empty()
        return Optional.of(mapper.convert(mongoRepository.save(mapper.convertToDocument(resource))))
    }

    @Override
    List<Resource> findAll() {
        return mongoRepository.findAllEnabled().stream().map(mapper::convert).collect()
    }

    @Override
    Optional<Resource> findById(String id) {
        Optional<ResourceDocument> byId = mongoRepository.findById(new ObjectId(id))
        if (byId.isEmpty()) return Optional.empty()
        return byId.map(mapper::convert)
    }

    @Override
    List<Resource> findByAttribute(String query) {
        return mongoRepository.findByQuery(query).stream().map(mapper::convert).collect()
    }

    @Override
    Optional<Resource> delete(String id) {
        Optional<ResourceDocument> byId = mongoRepository.findById(new ObjectId(id))
        if (byId.isEmpty()) return Optional.empty()
        ResourceDocument document = byId.get()
        document.setEnabled(false)
        return Optional.of(mapper.convert(mongoRepository.save(document)))
    }

    @Override
    Optional<Resource> update(String id, Resource resource) {
        if(!mongoRepository.existsById(new ObjectId(resource.getId()))) return Optional.empty()
        resource.setId(id)
        return Optional.of(mapper.convert(mongoRepository.save(mapper.convertToDocument(resource))))
    }

    @Override
    Optional<Resource> patch(String id, Resource resource) {
        Optional<ResourceDocument> byId = mongoRepository.findById(new ObjectId(id))
        if (byId.isEmpty()) return Optional.empty()
        ResourceDocument document = byId.get()
        if(resource.getName() != null) document.setName(resource.getName())
        if(resource.getId_last_user() != null) document.setId_last_user(resource.getId_last_user())
        if(resource.getDescription() != null) document.setDescription(resource.getDescription())
        if(resource.getModel() != null) document.setModel(resource.getModel())
        if(resource.getCharacteristics() != null) document.setCharacteristics(resource.getCharacteristics())
        return Optional.of(mapper.convert(mongoRepository.save(document)))
    }
}
