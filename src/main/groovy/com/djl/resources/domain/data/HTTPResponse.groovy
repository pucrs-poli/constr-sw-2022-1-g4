package com.djl.resources.domain.data

enum HTTPResponse {

    OK("OK", 200),
    CREATED("Created", 201),
    NOT_FOUND("Not found", 404),
    CONFLICT("Conflict", 409);

    private String message
    private Long code

    HTTPResponse(String message, Long code) {
        this.message = message
        this.code = code
    }

    String getMessage() {
        return message
    }

    Long getCode() {
        return code
    }
}