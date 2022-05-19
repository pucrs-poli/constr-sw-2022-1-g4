package com.example.resources.repository

import com.example.resources.domain.Resource
import org.springframework.stereotype.Repository

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
@Repository
public interface ResourceRepositoy extends MongoRepository{

    public Resource findByName(String name);
    Resource save(Resource resource);
    public Resource findById(String id);
}