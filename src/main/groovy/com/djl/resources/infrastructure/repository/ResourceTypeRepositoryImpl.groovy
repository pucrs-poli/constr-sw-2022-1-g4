package com.djl.resources.infrastructure.repository


import com.djl.resources.domain.data.model.ResourceType
import com.djl.resources.infrastructure.data.mapper.ResourceTypeMapper
import com.djl.resources.infrastructure.data.model.ResourceTypeDocument
import com.djl.resources.infrastructure.repository.persistence.ResourceTypeMongoRepository
import org.springframework.stereotype.Component

@Component
class ResourceTypeRepositoryImpl implements com.djl.resources.domain.repository.ResourceTypeRepository {

    private ResourceTypeMongoRepository mongoRepository

    private ResourceTypeMapper mapper

    ResourceTypeRepositoryImpl(ResourceTypeMongoRepository mongoRepository, ResourceTypeMapper mapper) {
        this.mongoRepository = mongoRepository
        this.mapper = mapper
    }

    @Override
    Optional<ResourceType> create(ResourceType resourceType) {
        if(mongoRepository.existsById(resourceType.getId())) return Optional.empty()
        return Optional.of(mapper.convert(mongoRepository.save(mapper.convertToDocument(resourceType))))
    }

    @Override
    List<ResourceType> findAllEnabled() {
        return mongoRepository.findAllEnabled().stream().map(mapper::convert).collect()
    }

    @Override
    Optional<ResourceType> findById(String id) {
        Optional<ResourceTypeDocument> byId = mongoRepository.findById(id)
        if (byId.isEmpty()) return Optional.empty()
        return byId.map(mapper::convert)
    }

    @Override
    Optional<ResourceType> delete(String id) {
        Optional<ResourceTypeDocument> byId = mongoRepository.findById(id)
        if (byId.isEmpty()) return Optional.empty()
        ResourceTypeDocument document = byId.get()
        document.setEnabled(false)
        return Optional.of(mapper.convert(mongoRepository.save(document)))
    }

    @Override
    Optional<ResourceType> update(String id, ResourceType resource) {
        if(!mongoRepository.existsById(resource.getId())) return Optional.empty()
        return Optional.of(mapper.convert(mongoRepository.save(mapper.convertToDocument(resource))))
    }

    @Override
    Optional<ResourceType> patch(String id, ResourceType resourceType) {
        Optional<ResourceTypeDocument> byId = mongoRepository.findById(id)
        if (byId.isEmpty()) return Optional.empty()
        ResourceTypeDocument document = byId.get()
        if(resourceType.getId() != null) document.setId(resourceType.getId())
        if(resourceType.getCategoria() != null) document.setCategoria(resourceType.getCategoria())
        return Optional.of(mapper.convert(mongoRepository.save(document)))
    }
}
