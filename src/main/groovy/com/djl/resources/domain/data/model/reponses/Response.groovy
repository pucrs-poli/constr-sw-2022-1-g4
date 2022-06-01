package com.djl.resources.domain.data.model.reponses

class Response {

    private final HTTPResponse response

    Response(HTTPResponse response) {
        this.response = response
    }

    HTTPResponse getResponse() {
        return response
    }
}
