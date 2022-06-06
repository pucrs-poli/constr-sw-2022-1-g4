package com.djl.resources.infrastructure.data.mapper;

import com.djl.resources.domain.data.model.ResourceType;
import com.djl.resources.infrastructure.data.model.ResourceTypeDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ResourceTypeMapper {

  ResourceTypeDocument convertToDocument(ResourceType resourceType);

  @Mapping(target = "id", expression = "java(resourceTypeDocument.getId().toString())")
  ResourceType convert(ResourceTypeDocument resourceTypeDocument);

}