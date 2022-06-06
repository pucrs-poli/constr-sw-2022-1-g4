package com.djl.resources.infrastructure.data.mapper;

import com.djl.resources.domain.data.model.Resource;
import com.djl.resources.infrastructure.data.model.ResourceDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ResourceMapper {

  ResourceDocument convertToDocument(Resource resource);

  @Mapping(target = "id", expression = "java(resourceDocument.getId().toString())")
  Resource convert(ResourceDocument resourceDocument);

}