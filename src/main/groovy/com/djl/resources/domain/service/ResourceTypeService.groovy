package com.djl.resources.domain.service

import com.djl.resources.domain.data.model.Resource
import com.djl.resources.domain.data.model.ResourceType
import com.djl.resources.domain.data.parser.QueryParser
import com.djl.resources.domain.repository.ResourceRepository
import com.djl.resources.domain.repository.ResourceTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ResourceTypeService {

    private ResourceRepository resourceRepository

    private ResourceTypeRepository resourceTypeRepository;

    @Autowired
    ResourceTypeService(ResourceTypeRepository resourceTypeRepository, ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository
        this.resourceTypeRepository = resourceTypeRepository
    }

    HttpEntity<ResourceType> createResourceType(ResourceType resourceType) {
        try {
            resourceType.setEnabled(true)
            resourceType.setId(UUID.randomUUID().toString())
            Optional<ResourceType> received = resourceTypeRepository.create(resourceType);
            if (received.isPresent()) return new ResponseEntity<ResourceType>(received.get(), HttpStatus.CREATED)
            return new ResponseEntity<ResourceType>(HttpStatus.CONFLICT)
        } catch (Exception exception) {
            return new ResponseEntity<ResourceType>(HttpStatus.BAD_REQUEST)
        }
    }

    HttpEntity<List<ResourceType>> getAllResourceTypes() {
        try {
            List<ResourceType> received = resourceTypeRepository.findAllEnabled()
            if (!received.isEmpty()) return ResponseEntity.ok(received)
            return new ResponseEntity<List<ResourceType>>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<List<ResourceType>>(HttpStatus.BAD_REQUEST)
        }
    }

    HttpEntity<ResourceType> getById(String id) {
        try {
            Optional<ResourceType> received = resourceTypeRepository.findById(id)
            if (received.isPresent()) return ResponseEntity.ok(received.get())
            return new ResponseEntity<ResourceType>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<ResourceType>(HttpStatus.BAD_REQUEST)
        }
    }

    HttpEntity<List<ResourceType>> getByQuery(String query) {
        try {
            List<ResourceType> received = resourceTypeRepository.findByQuery(new QueryParser().parse(query))
            if (!received.isEmpty()) return ResponseEntity.ok(received)
            return new ResponseEntity<List<ResourceType>>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<List<ResourceType>>(HttpStatus.BAD_REQUEST)
        }
    }

    HttpEntity<ResourceType> deleteById(String id) {
        try {
            Optional<ResourceType> received = resourceTypeRepository.delete(id)
            if (received.isEmpty())
                return new ResponseEntity<ResourceType>(HttpStatus.NOT_FOUND)
            resourceRepository.deleteAllOfGivenResourceType(id)
            return new ResponseEntity<ResourceType>(HttpStatus.NO_CONTENT)
        } catch (Exception exception) {
            return new ResponseEntity<ResourceType>(HttpStatus.BAD_REQUEST)
        }
    }

    HttpEntity<ResourceType> updateById(String id, ResourceType resourceType) {
        try {
            Optional<ResourceType> received = resourceTypeRepository.update(id, resourceType)
            if (received.isPresent()) return new ResponseEntity<ResourceType>(HttpStatus.OK)
            return new ResponseEntity<ResourceType>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<ResourceType>(HttpStatus.BAD_REQUEST)
        }
    }

    HttpEntity<ResourceType> patch(String id, ResourceType resourceType) {
        try {
            Optional<ResourceType> received = resourceTypeRepository.patch(id, resourceType)
            if (received.isPresent()) return new ResponseEntity<ResourceType>(HttpStatus.OK)
            return new ResponseEntity<ResourceType>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<ResourceType>(HttpStatus.BAD_REQUEST)
        }
    }

}
