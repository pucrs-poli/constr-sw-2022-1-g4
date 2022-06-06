package com.djl.resources.domain.data.parser

import com.djl.resources.domain.data.exception.InvalidOperatorException
import static MongoOperator.*

class QueryParser {

    String parse(final String query) {
        LinkedList<String> convertedQuery = new ArrayList<>()
        query.split("&").collect().forEach( (attribute) -> convertedQuery.add(parseAttribute((String)attribute)))

        String queryString = ""
        convertedQuery.forEach( (attribute) -> queryString + attribute.toString() + ",")

        queryString.substring(0, queryString.length() - 1)

        return queryString
    }

    private Attribute parseAttribute(final String attribute) {
        MongoOperator operator;
        if (attribute.contains(">=")) operator = GTE
        else if (attribute.contains("<=")) operator = LTE
        else if (attribute.contains("!=")) operator = NE
        else if (attribute.contains(">")) operator = GT
        else if (attribute.contains("<")) operator = LT
        else if (attribute.contains("=")) operator = EQ
        else throw new InvalidOperatorException("Invalid operator in query")
        String[] fieldValue = attribute.split(operator.getUrlOp())
        return new Attribute(fieldValue[0], operator, fieldValue[1])
    }
}
