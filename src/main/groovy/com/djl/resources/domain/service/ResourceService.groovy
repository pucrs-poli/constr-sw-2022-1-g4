package com.djl.resources.domain.service

import com.djl.resources.domain.data.model.Resource
import com.djl.resources.domain.data.parser.QueryParser
import com.djl.resources.domain.repository.ResourceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ResourceService {

    private ResourceRepository resourceRepositoy;

    @Autowired
    ResourceService(ResourceRepository resourceRepositoy) {
        this.resourceRepositoy = resourceRepositoy
    }

    ResponseEntity<Resource> createResource(Resource resource){
        try {
            Optional<Resource> received = resourceRepositoy.create(resource);
            if (received.isPresent()) return new ResponseEntity<Resource>(received.get(), HttpStatus.CREATED)
            return new ResponseEntity<Resource>(HttpStatus.CONFLICT)
        } catch (Exception exception) {
            return new ResponseEntity<Resource>(HttpStatus.BAD_REQUEST)
        }
    }

    ResponseEntity<List<Resource>> getAllResources() {
        try {
            List<Resource> received = resourceRepositoy.findAll()
            if (!received.isEmpty()) return ResponseEntity.ok(received)
            return new ResponseEntity<List<Resource>>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<List<Resource>>(HttpStatus.BAD_REQUEST)
        }
    }

    ResponseEntity<Resource> getById(String id){
        try {
            Optional<Resource> received = resourceRepositoy.findById(id)
            if (received.isPresent()) return ResponseEntity.ok(received.get())
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<Resource>(HttpStatus.BAD_REQUEST)
        }
    }

    ResponseEntity<List<Resource>> getByAttribute(String query){
        try {
            List<Resource> received = resourceRepositoy.findByAttribute(new QueryParser().parse(query))
            if (!received.isEmpty()) return ResponseEntity.ok(received)
            return new ResponseEntity<List<Resource>>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<List<Resource>>(HttpStatus.BAD_REQUEST)
        }
    }

    ResponseEntity<Resource> deleteById(String id){
        try {
            Optional<Resource> received = resourceRepositoy.delete(id)
            if (!received.isEmpty()) return new ResponseEntity<Resource>(HttpStatus.NO_CONTENT)
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<Resource>(HttpStatus.BAD_REQUEST)
        }
    }

    ResponseEntity<Resource> updateById(String id, Resource resource){
        try {
            Optional<Resource> received = resourceRepositoy.update(id, resource)
            if (received.isPresent()) return new ResponseEntity<Resource>(HttpStatus.OK)
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<Resource>(HttpStatus.BAD_REQUEST)
        }
    }

    ResponseEntity<Resource> patch(String id, Resource resource){
        try {
            Optional<Resource> received = resourceRepositoy.patch(id, resource)
            if (received.isPresent()) return new ResponseEntity<Resource>(HttpStatus.OK)
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND)
        } catch (Exception exception) {
            return new ResponseEntity<Resource>(HttpStatus.BAD_REQUEST)
        }
    }

}
