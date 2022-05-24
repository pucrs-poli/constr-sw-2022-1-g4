package com.example.resources.service

import com.example.resources.domain.Resource
import com.example.resources.domain.ResourceType
import com.example.resources.repository.ResourceRepositoy
import com.example.resources.repository.ResourceTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

import java.util.stream.Collectors
import java.util.stream.StreamSupport

@Service
public class ResourceTypeService {

    private ResourceTypeRepository resourceTypeRepository;

    @Autowired
    ResourceTypeService(ResourceTypeRepository resourceTypeRepository) {
        this.resourceTypeRepository = resourceTypeRepository
    }

    public String createResource(ResourceType resourceType){
        resourceTypeRepository.save(resourceType);
    }

    List<ResourceType> getAllResourceTypes(){
        return StreamSupport.stream(resourceTypeRepository.findAll().spliterator(), false)
        .collect(Collectors.toList())
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
