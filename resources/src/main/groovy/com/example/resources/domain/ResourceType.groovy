package com.example.resources.domain

import groovy.transform.Canonical
import lombok.Builder
import lombok.Data
import lombok.Getter
import lombok.Setter
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "resourceType")
@Canonical
class ResourceType {
    @Id
    String id
    String categoria
    boolean enabled
}
