package com.example.resources.repository

import com.example.resources.domain.ResourceType
import org.springframework.stereotype.Repository

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
@Repository
public interface ResourceTypeRepository extends MongoRepository{

    public ResourceType findByName(String category);
    ResourceType save(ResourceType resourceType);
    ResourceType findById(String id);
    ResourceType deleteById(String id); //ResourceType resourceType  -->  findById(id).enabled = false
    ResourceRepositoy updateById(String id); //how to???
}