package com.djl.resources.application.controller


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

@RestController("/resource")
class ResourceController {

    private com.djl.resources.domain.service.ResourceService service;

    ResourceController(com.djl.resources.domain.service.ResourceService service) {
        this.service = service
    }

    @PostMapping("/create")
    @ResponseBody createUser(@RequestBody com.djl.resources.domain.data.model.Resource resource){
        return service.createResource(resource)
    }

    @GetMapping
    @ResponseBody getAll(){
        return service.getAllResources()
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
    @ResponseBody updateAllObject(@PathVariable("id") String id, @RequestBody com.djl.resources.domain.data.model.Resource resource){
        return service.updateById(id, resource)
    }

    @PatchMapping
    @ResponseBody update(@PathVariable("id") String id, @RequestBody com.djl.resources.domain.data.model.Resource resource){
        return service.patch(id, resource)
    }

//    GET /resource/?atributo=valor&atributo>=valor&etc: recuperação de um objeto por uma query string complexa
//    @GetMapping
    @ResponseBody getResourceByAttributes(@RequestParam(required = false) String id,
                                          @RequestParam(required = false) String name,
                                          @RequestParam(required = false) Long id_last_user,
                                          @RequestParam(required = false) String description,
                                          @RequestParam(required = false) String model,
                                          @RequestParam(required = false) String characteristics){
    }

//    GET /resource/?atributo=valor: recuperação de um objeto por uma query string simples
//    @GetMapping
    @ResponseBody getResourceByAttribute(@RequestParam(required = false) String attribute) {

    }

}
