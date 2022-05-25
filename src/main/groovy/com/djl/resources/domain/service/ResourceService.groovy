package com.djl.resources.domain.service


import com.djl.resources.domain.data.model.reponses.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ResourceService {

    private com.djl.resources.domain.repository.ResourceRepository resourceRepositoy;

    @Autowired
    ResourceService(com.djl.resources.domain.repository.ResourceRepository resourceRepositoy) {
        this.resourceRepositoy = resourceRepositoy
    }

    Response createResource(com.djl.resources.domain.data.model.Resource resource){
        Optional<com.djl.resources.domain.data.model.Resource> received = resourceRepositoy.create(resource);
        if (received.isPresent()) return new com.djl.resources.domain.data.model.reponses.SuccessResponse(com.djl.resources.domain.data.HTTPResponse.CREATED, received.get())
        return new com.djl.resources.domain.data.model.reponses.FailureResponse(com.djl.resources.domain.data.HTTPResponse.CONFLICT, "Resource already exists")

    }

    Response getAllResources(){
        List<com.djl.resources.domain.data.model.Resource> received = resourceRepositoy.findAll();
        return new com.djl.resources.domain.data.model.reponses.SuccessResponse(com.djl.resources.domain.data.HTTPResponse.OK, received)
    }

    Response getById(String id){
        Optional<com.djl.resources.domain.data.model.Resource> received = resourceRepositoy.findById(id)
        return makeResponse(received)
    }

    Response getByAttribute(){

    }

    Response deleteById(String id){
        Optional<com.djl.resources.domain.data.model.Resource> received = resourceRepositoy.delete(id)
        return makeResponse(received)
    }

    Response updateById(String id, com.djl.resources.domain.data.model.Resource resource){
        Optional<com.djl.resources.domain.data.model.Resource> received = resourceRepositoy.update(id, resource)
        return makeResponse(received)
    }

    Response patch(String id, com.djl.resources.domain.data.model.Resource resource){
        Optional<com.djl.resources.domain.data.model.Resource> received = resourceRepositoy.patch(id, resource)
        return makeResponse(received)
    }

    Response makeResponse(Optional<com.djl.resources.domain.data.model.Resource> received) {
        if (received.isPresent()) return new com.djl.resources.domain.data.model.reponses.SuccessResponse(com.djl.resources.domain.data.HTTPResponse.OK, received.get())
        return new com.djl.resources.domain.data.model.reponses.FailureResponse(com.djl.resources.domain.data.HTTPResponse.NOT_FOUND, "Resource not found")
    }

}
