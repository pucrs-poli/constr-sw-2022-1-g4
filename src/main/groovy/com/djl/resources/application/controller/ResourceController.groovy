package com.djl.resources.application.controller

import com.djl.resources.domain.data.model.Resource
import com.djl.resources.domain.service.ResourceService
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
@RequestMapping("/resources")
class ResourceController implements ResourceApi{

    private ResourceService service;

    ResourceController(ResourceService service) {
        this.service = service
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<Resource> create(@RequestBody Resource resource){
        return service.createResource(resource)
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<List<Resource>> getAll(){
        return service.getAllResources()
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<Resource> get(@PathVariable("id") String id){
        return service.getById(id)
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<Resource> delete(@PathVariable("id") String id){
        return service.deleteById(id)
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<Resource> putUpdate(@PathVariable("id") String id, @RequestBody Resource resource){
        return service.updateById(id, resource)
    }

    @PatchMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<Resource> patchUpdate(@PathVariable("id") String id, @RequestBody Resource resource){
        return service.patch(id, resource)
    }

    @GetMapping(path = "/q{query}", produces = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<List<Resource>> processQuery(@PathVariable("query") String query){
        return service.getByAttribute(query);
    }

}
