package com.djl.resources.application.controller

import com.djl.resources.domain.data.model.ResourceType
import com.djl.resources.domain.service.ResourceTypeService
import org.springframework.http.HttpEntity
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/resourcetypes")
class ResourceTypeController implements ResourceTypeApi{

    private ResourceTypeService service;

    ResourceTypeController(ResourceTypeService service) {
        this.service = service
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<ResourceType> create(@RequestBody ResourceType resourceType){
        return service.createResourceType(resourceType)
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<List<ResourceType>> getAll(){
        return service.getAllResourceTypes()
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<ResourceType> get(@PathVariable("id") String id){
        return service.getById(id)
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<ResourceType> delete(@PathVariable("id") String id){
        return service.deleteById(id)
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<ResourceType> putUpdate(@PathVariable("id") String id, @RequestBody ResourceType resource){
        return service.updateById(id, resource)
    }

    @PatchMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<ResourceType> patchUpdate(@PathVariable("id") String id, @RequestBody ResourceType resource){
        return service.patch(id, resource)
    }

    @GetMapping(path = "/q{query}", produces = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<List<ResourceType>> processQuery(@PathVariable String query){
        return service.getByQuery(query)
    }

}
