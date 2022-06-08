package com.djl.resources.domain.data.model

import com.fasterxml.jackson.annotation.JsonCreator
import io.swagger.v3.oas.annotations.media.Schema

class Resource {

    @Schema(description = "Resource id", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id
    @Schema(description = "ResourceType id", example = "123e4567-e89b-12d3-a456-42661417400")
    private String resourceTypeIdentification
    @Schema(description = "Resource name", example = "notebook")
    private String name
    @Schema(description = "Last user identification", example = "42")
    private Long idLastUser
    @Schema(description = "Resource description", example = "13' notebook core i3 8gb 512gb")
    private String description
    @Schema(description = "Resource model", example = "Inspiron 15 3000")
    private String model
    @Schema(description = "Resource characteristics", example = "Black 110V")
    private String characteristics
    @Schema(description = "enable flag", example = "true")
    private boolean enabled

    Resource() {    }

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getResourceTypeIdentification() {
        return resourceTypeIdentification
    }

    void setResourceTypeIdentification(String resourceTypeIdentification) {
        this.resourceTypeIdentification = resourceTypeIdentification
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    Long getIdLastUser() {
        return idLastUser
    }

    void setIdLastUser(Long idLastUser) {
        this.idLastUser = idLastUser
    }

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        this.description = description
    }

    String getModel() {
        return model
    }

    void setModel(String model) {
        this.model = model
    }

    String getCharacteristics() {
        return characteristics
    }

    void setCharacteristics(String characteristics) {
        this.characteristics = characteristics
    }

    boolean getEnabled() {
        return enabled
    }

    void setEnabled(boolean enabled) {
        this.enabled = enabled
    }

}
