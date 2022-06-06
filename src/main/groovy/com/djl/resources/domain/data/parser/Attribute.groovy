package com.djl.resources.domain.data.parser

class Attribute {

    private final String field
    private final MongoOperator operator
    private final String value

    Attribute(String field, MongoOperator operator, String value) {
        this.field = field
        this.operator = operator
        this.value = value
    }

    String getField() {
        return field
    }

    MongoOperator getOperator() {
        return operator
    }

    String getValue() {
        return value
    }

    private String getQueryValue() {
        try {
            Long.parseLong(value)
            return value
        } catch (NumberFormatException exception) {
            return "'" + value + "'"
        }
    }

    @Override
    String toString() {
        return "'" + field + "': { \$" + operator.getMongoOp() + ": " + getQueryValue() + "}"
    }
}
