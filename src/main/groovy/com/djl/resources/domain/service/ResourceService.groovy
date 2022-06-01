package com.djl.resources.domain.service

import com.djl.resources.domain.data.model.Resource
import com.djl.resources.domain.data.model.reponses.FailureResponse
import com.djl.resources.domain.data.model.reponses.HTTPResponse
import com.djl.resources.domain.data.model.reponses.Response
import com.djl.resources.domain.data.model.reponses.SuccessResponse
import com.djl.resources.domain.data.parser.QueryParser
import com.djl.resources.domain.repository.ResourceRepository
import org.springframework.data.mongodb.core.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ResourceService {

    private ResourceRepository resourceRepositoy;

    @Autowired
    ResourceService(ResourceRepository resourceRepositoy) {
        this.resourceRepositoy = resourceRepositoy
    }

    Response createResource(Resource resource){
        Optional<Resource> received = resourceRepositoy.create(resource);
        if (received.isPresent()) return new SuccessResponse(HTTPResponse.CREATED, received.get())
        return new FailureResponse(HTTPResponse.CONFLICT, "Resource already exists")

    }

    Response getAllResources(){
        List<Resource> received = resourceRepositoy.findAll();
        return new SuccessResponse(HTTPResponse.OK, received)
    }

    Response getById(String id){
        Optional<Resource> received = resourceRepositoy.findById(id)
        return makeResponse(received)
    }

    Response getByAttribute(String query){
        Query parsedQuery = QueryParser.parse(query)
        resourceRepositoy.findByAttribute(parsedQuery)

    }

    Response deleteById(String id){
        Optional<Resource> received = resourceRepositoy.delete(id)
        return makeResponse(received)
    }

    Response updateById(String id, Resource resource){
        Optional<Resource> received = resourceRepositoy.update(id, resource)
        return makeResponse(received)
    }

    Response patch(String id, Resource resource){
        Optional<Resource> received = resourceRepositoy.patch(id, resource)
        return makeResponse(received)
    }

    Response makeResponse(Optional<Resource> received) {
        if (received.isPresent()) return new SuccessResponse(HTTPResponse.OK, received.get())
        return new FailureResponse(HTTPResponse.NOT_FOUND, "Resource not found")
    }

}
