package com.example.resources.service
import com.example.resources.domain.Resource
import com.example.resources.repository.ResourceRepositoy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
public class ResourceService {

    private ResourceRepositoy resourceRepositoy;

    @Autowired
    ResourceService(ResourceRepositoy resourceRepositoy) {
        this.resourceRepositoy = resourceRepositoy
    }

    public String createResource(Resource resource){
        resourceRepositoy.save(resource);
    }

    public Resource getAllResources(){
        resourceRepositoy.findAll()
    }

    public Resource getById(String id){
        resourceRepositoy.findById(id)
    }

    public Resource getByAttribute(){
    }

    HttpStatus deleteById(String id){
        resourceRepositoy.deleteById(id)
    }

    public Resource updateById(String id){
        resourceRepositoy.updateById(id)
    }

}
