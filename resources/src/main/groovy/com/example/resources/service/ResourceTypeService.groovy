package com.example.resources.service

import com.example.resources.controller.ResourceType
import com.example.resources.domain.Resource
import com.example.resources.repository.ResourceRepositoy
import com.example.resources.repository.ResourceTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
public class ResourceTypeService {
    @Autowired
    private ResourceTypeRepository resourceTypeRepository;

    public String createResource(ResourceType resourceType){
        resourceTypeRepository.save(resourceType);
    }

    public ResourceType getAllResourceTypes(){
        resourceTypeRepository.findAll()
    }

    public ResourceType getById(String id){
        resourceTypeRepository.findById(id)
    }

    public ResourceType getByAttribute(){
    }

    HttpStatus deleteById(String id){
        resourceTypeRepository.deleteById(id)
    }

    public ResourceType updateById(String id){
        resourceTypeRepository.updateById(id)
    }



}
