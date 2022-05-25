package com.djl.resources.infrastructure.repository

import com.djl.resources.domain.data.model.Resource
import com.djl.resources.domain.repository.ResourceRepository
import com.djl.resources.infrastructure.data.mapper.ResourceMapper
import com.djl.resources.infrastructure.data.model.ResourceDocument
import com.djl.resources.infrastructure.repository.persistence.ResourceMongoRepository
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
        if(mongoRepository.existsById(new ObjectId(resource.getId()))) return Optional.empty()
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
        return Optional.of(mapper.convert(mongoRepository.save(mapper.convertToDocument(resource))))
    }

    @Override
    Optional<Resource> patch(String id, Resource resource) {
        Optional<ResourceDocument> byId = mongoRepository.findById(new ObjectId(id))
        if (byId.isEmpty()) return Optional.empty()
        ResourceDocument document = byId.get()
        if(resource.getNome() != null) document.setNome(resource.getNome())
        if(resource.getId_ultimo_usuario() != null) document.setId_ultimo_usuario(resource.getId_ultimo_usuario())
        if(resource.getDescricao() != null) document.setDescricao(resource.getDescricao())
        if(resource.getModelo() != null) document.setModelo(resource.getModelo())
        if(resource.getCaracteristicas() != null) document.setCaracteristicas(resource.getCaracteristicas())
        return Optional.of(mapper.convert(mongoRepository.save(document)))
    }
}
