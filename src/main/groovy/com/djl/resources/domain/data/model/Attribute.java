package com.djl.resources.domain.data.model;

import com.djl.resources.domain.data.parser.MongoOperator;

public class Attribute {

  private final String field;
  private final MongoOperator operator;
  private final String value;

  public Attribute(String field, MongoOperator operator, String value) {
    this.field = field;
    this.operator = operator;
    this.value = value;
  }

  public String getField() {
    return field;
  }

  public MongoOperator getOperator() {
    return operator;
  }

  public String getValue() {
    return value;
  }
}