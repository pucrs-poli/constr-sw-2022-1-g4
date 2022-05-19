package com.example.resources.controller

import com.example.resources.service.ResourceTypeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController("/resourcetype")
class ResourceType {
    private ResourceTypeService service;

    @PostMapping("/create")
    public ResponseEntity<ResourceType> create(@RequestBody ResourceType resourceType){
        service.createType(Authorization, resourceType)
    }

//  GET /resourcetype: recuperação de todos os objetos Resource Type
//  @Todo precisa retornar somente os obg com enabled true
    @GetMapping
    public ResponseEntity<ResourceType> getAllResourceTypes(){
        service.getAllResourceTypes()
    }

//    GET /resourcetype/id: recuperação de um objeto pelo seu id
    @GetMapping("/{id}")
    public ResponseEntity<ResourceType> getResource(@PathVariable("id") String id){
        service.getById(id)
    }

//    GET /resourcetype/?atributo=valor: recuperação de um objeto por uma query string simples
    @GetMapping
    public ResponseEntity<ResourceType> getResourceByAttribute(@RequestParam(required = false) String id,
                                                           @RequestParam(required = false) String name){


    }

    //    DELETE /resourcetype/id: exclusão de um objeto
    // delete logico (muda enabled p falso)
    @DeleteMapping("/{id}")
    public ResponseEntity<ResourceType> delete(@PathVariable("id") String id){
        service.deleteById(id)
    }

//    PUT /resourcetype/id: atualização de todo o objeto
    @PutMapping("/{id}")
    public ResponseEntity<ResourceType> updateAllObject(@PathVariable("id") String id, @RequestBody ResourceType resource){
        service.updateById(id)
    }

//    PATCH /resourcetype/id: atualização de alguns atributos do objeto
    @PatchMapping
    public ResponseEntity<ResourceType> update(@PathVariable("id") String id, @RequestBody ResourceType resource){
        // How to?
    }
//    GET /resourcetype/?atributo=valor&atributo>=valor&etc: recuperação de um objeto por uma query string complexa
    @GetMapping
    public ResponseEntity<ResourceType> getResourceByAttributes(@RequestParam(required = false) String id,
                                                            @RequestParam(required = false) String name){
        // How to?
    }

}
