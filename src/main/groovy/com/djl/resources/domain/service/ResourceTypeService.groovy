package com.djl.resources.domain.service


import com.djl.resources.domain.data.model.reponses.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ResourceTypeService {

    private com.djl.resources.domain.repository.ResourceTypeRepository resourceTypeRepository;

    @Autowired
    ResourceTypeService(com.djl.resources.domain.repository.ResourceTypeRepository resourceTypeRepository) {
        this.resourceTypeRepository = resourceTypeRepository
    }

    Response createResourceType(com.djl.resources.domain.data.model.ResourceType resourceType){
        Optional<com.djl.resources.domain.data.model.ResourceType> received = resourceTypeRepository.create(resourceType);
        if (received.isPresent()) return new com.djl.resources.domain.data.model.reponses.SuccessResponse(com.djl.resources.domain.data.HTTPResponse.CREATED, received.get())
        return new com.djl.resources.domain.data.model.reponses.FailureResponse(com.djl.resources.domain.data.HTTPResponse.CONFLICT, "ResourceType already exists")

    }

    Response getAllResourceTypes(){
        List<com.djl.resources.domain.data.model.ResourceType> received = resourceTypeRepository.findAllEnabled()
        return new com.djl.resources.domain.data.model.reponses.SuccessResponse(com.djl.resources.domain.data.HTTPResponse.OK, received)
    }

    Response getById(String id){
        Optional<com.djl.resources.domain.data.model.ResourceType> received = resourceTypeRepository.findById(id)
        return makeResponse(received)
    }

    Response getByAttribute() {

    }

    Response deleteById(String id){
        Optional<com.djl.resources.domain.data.model.ResourceType> received = resourceTypeRepository.delete(id)
        return makeResponse(received)
    }

    Response updateById(String id, com.djl.resources.domain.data.model.ResourceType resourceType){
        Optional<com.djl.resources.domain.data.model.ResourceType> received = resourceTypeRepository.update(id, resourceType)
        return makeResponse(received)
    }

    Response patch(String id, com.djl.resources.domain.data.model.ResourceType resourceType){
        Optional<com.djl.resources.domain.data.model.ResourceType> received = resourceTypeRepository.patch(id, resourceType)
        return makeResponse(received)
    }

    Response makeResponse(Optional<com.djl.resources.domain.data.model.ResourceType> received) {
        if (received.isPresent()) return new com.djl.resources.domain.data.model.reponses.SuccessResponse(com.djl.resources.domain.data.HTTPResponse.OK, received.get())
        return new com.djl.resources.domain.data.model.reponses.FailureResponse(com.djl.resources.domain.data.HTTPResponse.NOT_FOUND, "Resource not found")
    }

}
