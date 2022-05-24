package com.example.resources.repository

import com.example.resources.domain.ResourceType
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
@Component
public interface ResourceTypeRepository extends CrudRepository<ResourceType,String>{

}