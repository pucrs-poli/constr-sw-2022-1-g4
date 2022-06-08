package com.djl.resources.application.controller;

import com.djl.resources.domain.data.model.HttpResponse;
import com.djl.resources.domain.data.model.Resource;
import com.djl.resources.domain.data.model.ResourceType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpEntity;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.PATH;

public interface ResourceApi {

  @Operation(summary = "Operation performed by saving a received resource on the database",
      description = "Create a new resource on the database",
      responses = {
          @ApiResponse(responseCode = HttpResponse.STATUS_CREATED, description = HttpResponse.CREATED, content = @Content(schema = @Schema(implementation = Resource.class))),
          @ApiResponse(responseCode = HttpResponse.STATUS_CONFLICT, description = HttpResponse.CONFLICT),
          @ApiResponse(responseCode = HttpResponse.STATUS_BAD_REQUEST, description = HttpResponse.BAD_REQUEST)
      }
  )
  HttpEntity<Resource> create(
      @RequestBody(required = true, content = @Content(schema = @Schema(implementation = Resource.class))) Resource resource
  );

  @Operation(summary = "Operation performed by retrieving all enabled resources from the database",
      description = "Get all resources",
      responses = {
          @ApiResponse(responseCode = HttpResponse.STATUS_OK, description = HttpResponse.OK, content = @Content(array = @ArraySchema(schema = @Schema(implementation = Resource.class)))),
          @ApiResponse(responseCode = HttpResponse.STATUS_NOT_FOUND, description = HttpResponse.NOT_FOUND),
          @ApiResponse(responseCode = HttpResponse.STATUS_INTERNAL_SERVER_ERROR, description = HttpResponse.INTERNAL_SERVER_ERROR)
      }
  )
  HttpEntity<Resource> getAll();

  @Operation(summary = "Operation performed by retrieving one resource with a id equal to the one received",
      description = "Get resource by id",
      responses = {
          @ApiResponse(responseCode = HttpResponse.STATUS_OK, description = HttpResponse.OK, content = @Content(schema = @Schema(implementation = Resource.class))),
          @ApiResponse(responseCode = HttpResponse.STATUS_NOT_FOUND, description = HttpResponse.NOT_FOUND),
          @ApiResponse(responseCode = HttpResponse.STATUS_INTERNAL_SERVER_ERROR, description = HttpResponse.INTERNAL_SERVER_ERROR)
      }
  )
  HttpEntity<Resource> get(
      @Parameter(in = PATH, name = "id", required = true, description = "resource id", example = "123e4567-e89b-12d3-a456-42661417400") String id
  );

  @Operation(summary = "Operation performed by logically deleting a resource with a received id on the database",
      description = "Deleting a resource on the database",
      responses = {
          @ApiResponse(responseCode = HttpResponse.STATUS_NO_CONTENT, description = HttpResponse.NO_CONTENT),
          @ApiResponse(responseCode = HttpResponse.STATUS_NOT_FOUND, description = HttpResponse.NOT_FOUND),
          @ApiResponse(responseCode = HttpResponse.STATUS_INTERNAL_SERVER_ERROR, description = HttpResponse.STATUS_INTERNAL_SERVER_ERROR)
      }
  )
  HttpEntity<Resource> delete(
      @Parameter(in = PATH, name = "id", required = true, description = "resource id", example = "123e4567-e89b-12d3-a456-42661417400") String id
  );

  @Operation(summary = "Operation performed by overwriting or creating a received resource on the database",
      description = "PUT a resource in the database",
      responses = {
          @ApiResponse(responseCode = HttpResponse.STATUS_OK, description = HttpResponse.OK),
          @ApiResponse(responseCode = HttpResponse.STATUS_NOT_FOUND, description = HttpResponse.NOT_FOUND),
          @ApiResponse(responseCode = HttpResponse.STATUS_BAD_REQUEST, description = HttpResponse.BAD_REQUEST)
      }
  )
  HttpEntity<Resource> putUpdate(
      @Parameter(in = PATH, name = "id", required = true, description = "resource id", example = "123e4567-e89b-12d3-a456-42661417400") String id,
      @RequestBody(required = true, content = @Content(schema = @Schema(implementation = Resource.class))) Resource resource
  );

  @Operation(summary = "Operation performed by partially updating a received resource on the database",
      description = "Update a resource",
      responses = {
          @ApiResponse(responseCode = HttpResponse.STATUS_OK, description = HttpResponse.OK),
          @ApiResponse(responseCode = HttpResponse.STATUS_NOT_FOUND, description = HttpResponse.NOT_FOUND),
          @ApiResponse(responseCode = HttpResponse.STATUS_BAD_REQUEST, description = HttpResponse.BAD_REQUEST)
      }
  )
  HttpEntity<Resource> patchUpdate(
      @Parameter(in = PATH, name = "id", required = true, description = "resource id", example = "123e4567-e89b-12d3-a456-42661417400") String id,
      @RequestBody(required = true, content = @Content(schema = @Schema(implementation = Resource.class))) Resource resource
  );

  @Operation(summary = "Operation performed by processing a query in the database and retrieving its result",
      description = "Send a query in the database",
      responses = {
          @ApiResponse(responseCode = HttpResponse.STATUS_OK, description = HttpResponse.OK, content = @Content(schema = @Schema(implementation = Resource.class))),
          @ApiResponse(responseCode = HttpResponse.STATUS_NOT_FOUND, description = HttpResponse.NOT_FOUND),
          @ApiResponse(responseCode = HttpResponse.STATUS_BAD_REQUEST, description = HttpResponse.BAD_REQUEST)
      }
  )
  HttpEntity<Resource> processQuery(
      @Parameter(in = PATH, name = "query", required = true, description = "implementation query", example = "123e4567-e89b-12d3-a456-42661417400") String query
  );
}