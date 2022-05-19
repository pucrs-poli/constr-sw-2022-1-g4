package com.example.resources.domain

import org.springframework.data.annotation.Id

class ResourceType {
    @Id
    public String id;

    private String categoria;

    private boolean enabled;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
