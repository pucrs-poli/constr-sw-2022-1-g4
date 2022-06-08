package com.djl.resources.infrastructure.data.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "resources")
class ResourceDocument {

    @Id
    private String id;
    private String resourceTypeIdentification;
    private String name;
    private Long idLastUser;
    private String description;
    private String model;
    private String characteristics;
    private boolean enabled;

    String getId() {
        return id
    }

    String getResourceTypeIdentification() {
        return resourceTypeIdentification
    }

    void setId(String id) {
        this.id = id
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
