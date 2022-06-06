package com.djl.resources.application.controller

import com.djl.resources.domain.data.model.ResourceType
import com.djl.resources.domain.service.ResourceTypeService
import org.springframework.http.HttpEntity
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
class ResourceTypeController {

    private ResourceTypeService service;

    ResourceTypeController(ResourceTypeService service) {
        this.service = service
    }

    @PostMapping()
    HttpEntity<ResourceType> create(@RequestBody ResourceType resourceType){
        return service.createResourceType(resourceType)
    }

    @GetMapping
    HttpEntity<List<ResourceType>> getAllResourceTypes(){
        return service.getAllResourceTypes()
    }

    @GetMapping("/{id}")
    HttpEntity<ResourceType> getResource(@PathVariable("id") String id){
        return service.getById(id)
    }

    @DeleteMapping("/{id}")
    HttpEntity<ResourceType> delete(@PathVariable("id") String id){
        return service.deleteById(id)
    }

    @PutMapping("/{id}")
    HttpEntity<ResourceType> updateAllObject(@PathVariable("id") String id, @RequestBody ResourceType resource){
        return service.updateById(id, resource)
    }

    @PatchMapping("/{id}")
    HttpEntity<ResourceType> update(@PathVariable("id") String id, @RequestBody ResourceType resource){
        return service.patch(id, resource)
    }

    @GetMapping("/q?{query}")
    HttpEntity<List<ResourceType>> getResourceByAttribute(@PathVariable String query){
        return service.getByQuery(query)
    }

}
