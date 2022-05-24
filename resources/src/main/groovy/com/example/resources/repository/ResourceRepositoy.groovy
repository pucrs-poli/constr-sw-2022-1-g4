package com.example.resources.repository

import com.example.resources.domain.Resource
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository


@Component
public interface ResourceRepositoy extends CrudRepository<Resource,String>{

}