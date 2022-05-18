package com.example.resources.service

import com.example.resources.domain.Resource
import com.example.resources.repository.ResourceRepositoy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
public class ResourceService {
    @Autowired
    private ResourceRepositoy resourceRepositoy;

    public String createResource(Resource resource){
        resourceRepositoy.save(resource);
    }

}
