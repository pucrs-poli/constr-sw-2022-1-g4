package com.djl.resources.infrastructure.data.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "resource")
class ResourceDocument {

    @Id
    private ObjectId id;
    private String name;
    private Long id_last_user;
    private String description;
    private String model;
    private String characteristics;
    private boolean enabled;

    ObjectId getId() {
        return id
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
