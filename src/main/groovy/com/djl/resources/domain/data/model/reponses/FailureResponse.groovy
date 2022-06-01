package com.djl.resources.domain.data.model.reponses

class FailureResponse extends Response{

    String message

    FailureResponse(HTTPResponse response, String message) {
        super(response)
        this.message = message
    }

    String getMessage() {
        return message
    }

    void setMessage(String message) {
        this.message = message
    }
}
