package com.djl.resources.domain.data.model

import com.fasterxml.jackson.annotation.JsonCreator

class Resource {

    private String id
    private String resourceTypeIdentificator
    private String name
    private Long id_last_user
    private String description
    private String model
    private String characteristics
    private boolean enabled

    Resource() {    }

    @JsonCreator
    Resource(String resourceTypeIdentificator, String name, Long id_last_user, String description, String model, String characteristics) {
        this.id = new UUID().toString()
        this.resourceTypeIdentificator = resourceTypeIdentificator
        this.name = name
        this.id_last_user = id_last_user
        this.description = description
        this.model = model
        this.characteristics = characteristics
        this.enabled = true
    }

    Resource(String id, String resourceTypeIdentificator, String name, Long id_last_user, String description, String model, String characteristics, boolean enabled) {
        this.id = id
        this.resourceTypeIdentificator = resourceTypeIdentificator
        this.name = name
        this.id_last_user = id_last_user
        this.description = description
        this.model = model
        this.characteristics = characteristics
        this.enabled = enabled
    }

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getResourceTypeIdentificator() {
        return resourceTypeIdentificator
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    Long getId_last_user() {
        return id_last_user
    }

    void setId_last_user(Long id_last_user) {
        this.id_last_user = id_last_user
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
