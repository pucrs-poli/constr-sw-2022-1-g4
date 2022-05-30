package com.djl.resources.infrastructure.data.mapper

import com.djl.resources.domain.data.model.Resource
import com.djl.resources.infrastructure.data.model.ResourceDocument
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ResourceMapper {

    ResourceDocument convertToDocument(Resource resource);

    Resource convert(ResourceDocument resourceDocument);

}