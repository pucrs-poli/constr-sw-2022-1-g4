package com.jld.keycloackapi.infrastructure.data.mapper;

import com.jld.keycloackapi.domain.dto.ResourceTypeDTO;
import com.jld.keycloackapi.infrastructure.data.model.document.ResourceTypeDocument;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ResourceTypeMapper {

	ResourceTypeDTO documentToDTO(ResourceTypeDocument document);

	ResourceTypeDocument dtoToDocument(ResourceTypeDTO dto);

}
