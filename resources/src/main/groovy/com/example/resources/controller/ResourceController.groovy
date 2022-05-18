package com.example.resources.controller

import com.example.resources.domain.Resource
import com.example.resources.service.ResourceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/resource")
class ResourceController {
    private ResourceService service;

    @PostMapping("/create")
    public ResponseEntity<Resource> createUser(@RequestBody ){

    }

}
