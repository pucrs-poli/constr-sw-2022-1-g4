package com.example.resources.controller

import com.example.resources.domain.Resource
import com.example.resources.service.ResourceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/resource")
class ResourceController {

    private ResourceService service;

    ResourceController(ResourceService service) {
        this.service = service
    }

    @PostMapping("/create")
    public ResponseEntity<Resource> createUser(@RequestBody Resource resource){
        service.createResource(resource)
    }

//  GET /resource: recuperação de todos os objetos
//  @Todo precisa retornar somente os obg com enabled true
   // @GetMapping
    public ResponseEntity<Resource> getAll(){

    }

//    GET /resource/id: recuperação de um objeto pelo seu id
    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResource(@PathVariable("id") String id){

    }

//    GET /resource/?atributo=valor: recuperação de um objeto por uma query string simples
    @GetMapping
    public ResponseEntity<Resource> getResourceByAttribute(@RequestParam(required = false) String attribute){

    }

    //    DELETE /resource/id: exclusão de um objeto
    // delete logico (muda enabled p falso)
    @DeleteMapping("/{id}")
    public ResponseEntity<Resource> delete(@PathVariable("id") String id){

    }

//    PUT /resource/id: atualização de todo o objeto
    @PutMapping("/{id}")
    public ResponseEntity<Resource> updateAllObject(@PathVariable("id") String id, @RequestBody Resource resource){

    }

//    PATCH /resource/id: atualização de alguns atributos do objeto
    @PatchMapping
    public ResponseEntity<Resource> update(@PathVariable("id") String id, @RequestBody Resource resource){

    }
//    GET /resource/?atributo=valor&atributo>=valor&etc: recuperação de um objeto por uma query string complexa
    //@GetMapping
    public ResponseEntity<Resource> getResourceByAttributes(@RequestParam(required = false) String id,
                                                           @RequestParam(required = false) String name,
                                                           @RequestParam(required = false) Long id_last_user,
                                                           @RequestParam(required = false) String description,
                                                           @RequestParam(required = false) String model,
                                                           @RequestParam(required = false) String characteristics,
                                                           @RequestParam(required = false) String enabled){
    }

}
