package com.djl.resources.application.controller

import com.djl.resources.domain.data.model.ResourceType
import com.djl.resources.domain.service.ResourceTypeService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController("/resourcetype")
class ResourceTypeController {

    private ResourceTypeService service;

    ResourceTypeController(ResourceTypeService service) {
        this.service = service
    }

    @PostMapping("/create")
    @ResponseBody create(@RequestBody ResourceType resourceType){
        return service.createResourceType(resourceType)
    }

    @GetMapping
    @ResponseBody getAllResourceTypes(){
        return service.getAllResourceTypes()
    }

    @GetMapping("/{id}")
    @ResponseBody getResource(@PathVariable("id") String id){
        return service.getById(id)
    }

    @DeleteMapping("/{id}")
    @ResponseBody delete(@PathVariable("id") String id){
        return service.deleteById(id)
    }

    @PutMapping("/{id}")
    @ResponseBody updateAllObject(@PathVariable("id") String id, @RequestBody ResourceType resource){
        return service.updateById(id)
    }

    @PatchMapping
    @ResponseBody update(@PathVariable("id") String id, @RequestBody ResourceType resource){
        return service.patch(id)
    }

//    GET /resourcetype/?atributo=valor&atributo>=valor&etc: recuperação de um objeto por uma query string complexa
//    @GetMapping("?")
    @ResponseBody getResourceByAttributes(@RequestParam(required = false) String id,
                                                                @RequestParam(required = false) String name){

    }

//    GET /resourcetype/?atributo=valor: recuperação de um objeto por uma query string simple
//    @GetMapping
    @ResponseBody getResourceByAttribute(@RequestParam(required = false) String id,
                                         @RequestParam(required = false) String name){


    }

}
