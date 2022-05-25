package com.djl.resources.domain.data.model

class Resource {

    private final String id;
    private String name;
    private Long id_last_user;
    private String description;
    private String model;
    private String characteristics;

    Resource(ResourceBuilder builder) {
        id = UUID.randomUUID().toString()
        name = builder.name
        id_last_user = builder.id_last_user
        description = builder.description
        model = builder.model
        characteristics = builder.characteristics
    }

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

    class ResourceBuilder {

        private String id;
        private String name;
        private Long id_last_user;
        private String description;
        private String model;
        private String characteristics;

        ResourceBuilder withId(String id) {
            this.id = id
            return this
        }

        ResourceBuilder withName(String name) {
            this.name = name
            return this
        }

        ResourceBuilder withIdLastUser(Long id_last_user) {
            this.id_last_user = id_last_user
            return this
        }

        ResourceBuilder withDescription(String description) {
            this.description = description
            return this
        }

        ResourceBuilder withModel(String model) {
            this.model = model
            return this
        }

        ResourceBuilder withCharacteristics(String characteristics) {
            this.characteristics = characteristics
            return this
        }

        Resource build() {
            return new Resource(this)
        }

    }
}
