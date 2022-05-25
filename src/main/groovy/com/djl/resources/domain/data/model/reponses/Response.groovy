package com.djl.resources.domain.data.model.reponses

class Response {

    private final com.djl.resources.domain.data.HTTPResponse response

    Response(com.djl.resources.domain.data.HTTPResponse response) {
        this.response = response
    }

    com.djl.resources.domain.data.HTTPResponse getResponse() {
        return response
    }
}
