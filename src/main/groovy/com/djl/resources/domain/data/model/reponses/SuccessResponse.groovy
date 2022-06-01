package com.djl.resources.domain.data.model.reponses


import com.djl.resources.domain.data.model.Resource
import com.djl.resources.domain.data.model.ResourceType

class SuccessResponse extends Response{

    List results

    SuccessResponse(HTTPResponse response, List results) {
        super(response)
        this.results = results
    }

    SuccessResponse(HTTPResponse response, ResourceType result) {
        super(response)
        this.results = new ArrayList<>()
        results.add(result)
    }


    SuccessResponse(HTTPResponse response, Resource result) {
        super(response)
        this.results = new ArrayList<>()
        results.add(result)
    }


    List getResults() {
        return results
    }

    void setResults(List results) {
        this.results = results
    }
}
