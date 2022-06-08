package com.djl.resources.domain.data.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import io.swagger.v3.oas.annotations.media.Schema

class ResourceType {

    @Schema(description = "Resource type id", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id
    @Schema(description = "Resource category", example = "computers")
    private String category
    @Schema(description = "enable flag", example = "true")
    private boolean enabled

    ResourceType() {    }

    ResourceType(ResourceType resourceType) {
        resourceType.setId(UUID.randomUUID().toString())
        this.category = category
        resourceType.setEnabled(true)
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
