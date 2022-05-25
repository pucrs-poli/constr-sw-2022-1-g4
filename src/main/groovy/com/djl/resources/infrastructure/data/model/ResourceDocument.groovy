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

    String getId() {
        return id
    }

    String getNome() {
        return name
    }

    void setNome(String nome) {
        this.name = nome
    }

    Long getId_ultimo_usuario() {
        return id_last_user
    }

    void setId_ultimo_usuario(Long id_ultimo_usuario) {
        this.id_last_user = id_ultimo_usuario
    }

    String getDescricao() {
        return description
    }

    void setDescricao(String descricao) {
        this.description = descricao
    }

    String getModelo() {
        return model
    }

    void setModelo(String modelo) {
        this.model = modelo
    }

    String getCaracteristicas() {
        return characteristics
    }

    void setCaracteristicas(String caracteristicas) {
        this.characteristics = caracteristicas
    }

    boolean getEnabled() {
        return enabled
    }

    void setEnabled(boolean enabled) {
        this.enabled = enabled
    }

}
