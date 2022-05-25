package com.djl.resources.infrastructure.data.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "resourceType")
class ResourceTypeDocument {

    @Id
    private String id
    private String categoria
    private boolean enabled

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

    boolean getEnabled() {
        return enabled
    }

    void setEnabled(boolean enabled) {
        this.enabled = enabled
    }
}
