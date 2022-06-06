package com.djl.resources.infrastructure.data.mapper

import com.djl.resources.domain.data.model.ResourceType
import com.djl.resources.infrastructure.data.model.ResourceTypeDocument
import org.mapstruct.Mapper
import org.mapstruct.NullValueCheckStrategy
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
interface ResourceTypeMapper {

    ResourceTypeDocument convertToDocument(ResourceType resourceType);

    ResourceType convert(ResourceTypeDocument resourceTypeDocument);

}