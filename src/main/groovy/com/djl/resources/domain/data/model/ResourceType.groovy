package com.djl.resources.domain.data.model

class ResourceType {

    private String id
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
