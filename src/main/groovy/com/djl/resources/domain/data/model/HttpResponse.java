package com.djl.resources.domain.data.model;

public final class HttpResponse {

  private HttpResponse() {
  }

  public static final String CREATED = "Created";
  public static final String BAD_GATEWAY = "Bad Gateway";
  public static final String BAD_REQUEST = "Bad Request";
  public static final String METHOD_NOT_ALLOWED = "Method Not Allowed";
  public static final String CONFLICT = "Conflict";
  public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
  public static final String NO_CONTENT = "No Content";
  public static final String NOT_FOUND = "Not Found";
  public static final String OK = "Ok";
  public static final String ACCEPT = "Accept";
  public static final String UNAUTHORIZED = "Unauthorized";
  public static final String FORBIDDEN = "Forbidden";
  public static final String PRECONDITION_FAILED = "Precondition Failed";
  public static final String UNPROCESSABLE_ENTITY = "Unprocessable Entity";
  public static final String PRECONDITION_REQUIRED = "Precondition Required";

  public static final String STATUS_CREATED = "201";
  public static final String STATUS_BAD_GATEWAY = "502";
  public static final String STATUS_BAD_REQUEST = "400";
  public static final String STATUS_METHOD_NOT_ALLOWED = "405";
  public static final String STATUS_CONFLICT = "409";
  public static final String STATUS_INTERNAL_SERVER_ERROR = "500";
  public static final String STATUS_NO_CONTENT = "204";
  public static final String STATUS_NOT_FOUND = "404";
  public static final String STATUS_OK = "200";
  public static final String STATUS_ACCEPT = "202";
  public static final String STATUS_UNAUTHORIZED = "401";
  public static final String STATUS_FORBIDDEN = "403";
  public static final String STATUS_PRECONDITION_FAILED = "412";
  public static final String STATUS_UNPROCESSABLE_ENTITY = "422";
  public static final String STATUS_PRECONDITION_REQUIRED = "428";
}
