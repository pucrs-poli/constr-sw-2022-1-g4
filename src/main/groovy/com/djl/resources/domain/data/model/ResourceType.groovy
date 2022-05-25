package com.djl.resources.domain.data.model

import groovy.transform.Canonical
import lombok.Builder
import lombok.Data
import lombok.Getter
import lombok.Setter
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

class ResourceType {

    private String id
    private String categoria

    ResourceType(ResourceTypeBuilder builder) {
        this.id = builder.id
        this.categoria = builder.categoria
    }

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getCategoria() {
        return categoria
    }

    void setCategoria(String categoria) {
        this.categoria = categoria
    }

    class ResourceTypeBuilder {

        private String id
        private String categoria

        ResourceTypeBuilder withId(String id) {
            this.id = id
            return this
        }

        ResourceTypeBuilder withCategoria(String categoria) {
            this.categoria = categoria
            return this
        }
    }
}
