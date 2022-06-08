package com.djl.resources.domain.service

import com.djl.resources.domain.data.model.Resource
import com.djl.resources.domain.data.parser.QueryParser
import com.djl.resources.domain.repository.ResourceRepository
import com.djl.resources.domain.repository.ResourceTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ResourceService {

    private ResourceRepository resourceRepository

    private ResourceTypeRepository resourceTypeRepository

    @Autowired
    ResourceService(ResourceRepository resourceRepository, ResourceTypeRepository resourceTypeRepository) {
        this.resourceTypeRepository = resourceTypeRepository
        this.resourceRepository = resourceRepository
    }

    ResponseEntity<Resource> createResource(Resource resource){
        try {
            resource.setEnabled(true)
            resource.setId(UUID.randomUUID().toString())
            if (!resourceTypeRepository.findById(resource.getResourceTypeIdentification()).isPresent())
                return new ResponseEntity<Resource>(HttpStatus.CONFLICT)
            Optional<Resource> received = resourceRepository.create(resource);
            if (received.isPresent()) return new ResponseEntity<Resource>(received.get(), HttpStatus.CREATED)
            return new ResponseEntity<Resource>(HttpStatus.CONFLICT)
        } catch (Exception exception) {
            return new ResponseEntity<Resource>(HttpStatus.BAD_REQUEST)
        }
    }

    ResponseEntity<List<Resource>> getAllResources() {
        try {
            List<Resource> received = resourceRepository.findAll()
            if (!received.isEmpty()) return ResponseEntity.ok(received)
            return new ResponseEntity<List<Resource>>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<List<Resource>>(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    ResponseEntity<Resource> getById(String id){
        try {
            Optional<Resource> received = resourceRepository.findById(id)
            if (received.isPresent()) return ResponseEntity.ok(received.get())
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<Resource>(HttpStatus.BAD_REQUEST)
        }
    }

    ResponseEntity<List<Resource>> getByAttribute(String query){
        try {
            List<Resource> received = resourceRepository.findByAttribute(new QueryParser().parse(query))
            if (!received.isEmpty()) return ResponseEntity.ok(received)
            return new ResponseEntity<List<Resource>>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<List<Resource>>(HttpStatus.BAD_REQUEST)
        }
    }

    ResponseEntity<Resource> deleteById(String id){
        try {
            Optional<Resource> received = resourceRepository.delete(id)
            if (!received.isEmpty()) return new ResponseEntity<Resource>(HttpStatus.NO_CONTENT)
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<Resource>(HttpStatus.BAD_REQUEST)
        }
    }

    ResponseEntity<Resource> updateById(String id, Resource resource){
        try {
            Optional<Resource> received = resourceRepository.update(id, resource)
            if (received.isPresent()) return new ResponseEntity<Resource>(HttpStatus.OK)
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<Resource>(HttpStatus.BAD_REQUEST)
        }
    }

    ResponseEntity<Resource> patch(String id, Resource resource){
        try {
            Optional<Resource> received = resourceRepository.patch(id, resource)
            if (received.isPresent()) return new ResponseEntity<Resource>(HttpStatus.OK)
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<Resource>(HttpStatus.BAD_REQUEST)
        }
    }

}
