package com.djl.resources.infrastructure.data.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "resourceType")
class ResourceTypeDocument {

    @Id
    private ObjectId id
    private String category
    private boolean enabled

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getCategory() {
        return category
    }

    void setCategory(String category) {
        this.category = category
    }

    boolean getEnabled() {
        return enabled
    }

    void setEnabled(boolean enabled) {
        this.enabled = enabled
    }
}
