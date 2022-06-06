package com.djl.resources.application.controller

import com.djl.resources.domain.data.model.Resource
import com.djl.resources.domain.service.ResourceService
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
@RequestMapping("/resources")
class ResourceController {

    private ResourceService service;

    ResourceController(ResourceService service) {
        this.service = service
    }

    @PostMapping()
    HttpEntity<Resource> createUser(@RequestBody Resource resource){
        return service.createResource(resource)
    }

    @GetMapping
    HttpEntity<List<Resource>> getAll(){
        return service.getAllResources()
    }

    @GetMapping("/{id}")
    HttpEntity<Resource> getResource(@PathVariable("id") String id){
        return service.getById(id)
    }

    @DeleteMapping("/{id}")
    HttpEntity<Resource> delete(@PathVariable("id") String id){
        return service.deleteById(id)
    }

    @PutMapping("/{id}")
    HttpEntity<Resource> updateAllObject(@PathVariable("id") String id, @RequestBody Resource resource){
        return service.updateById(id, resource)
    }

    @PatchMapping("/{id}")
    HttpEntity<Resource> update(@PathVariable("id") String id, @RequestBody Resource resource){
        return service.patch(id, resource)
    }

    @GetMapping("/?{query}")
    HttpEntity<List<Resource>> getResourceByAttributes(@PathVariable("query") String query){
        return service.getByAttribute(query);
    }

}
