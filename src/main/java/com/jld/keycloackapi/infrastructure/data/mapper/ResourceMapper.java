package com.jld.keycloackapi.infrastructure.data.mapper;

import com.jld.keycloackapi.domain.dto.ResourceDTO;
import com.jld.keycloackapi.infrastructure.data.model.document.ResourceDocument;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ResourceMapper {

	ResourceDTO documentToDTO(ResourceDocument document);

	ResourceDocument dtoToDocument(ResourceDTO dto);

}
