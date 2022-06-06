package com.djl.resources.domain.data.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

class ResourceType {

    private String id
    private String category
    private boolean enabled

    ResourceType() {    }

    @JsonCreator
    ResourceType(String category) {
        this.id = UUID.randomUUID().toString()
        this.category = category
        this.enabled = true
    }

    ResourceType(String id, String category, boolean enabled) {
        this.id = UUID.randomUUID().toString()
        this.category = category
        this.enabled = true
    }

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
