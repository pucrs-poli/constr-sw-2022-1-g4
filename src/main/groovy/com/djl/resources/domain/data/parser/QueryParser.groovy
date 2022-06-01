package com.djl.resources.domain.data.parser

import com.djl.resources.domain.data.exception.InvalidOperatorException
import org.springframework.data.mongodb.core.query.Criteria

import static MongoOperator.*

import com.djl.resources.domain.data.model.Attribute
import org.springframework.data.mongodb.core.query.Query

class QueryParser { //sql injection flashbacks

    Query parse(final String query) {
        ArrayList<Attribute> convertedQuery = new ArrayList<>()
        query.split("&").collect().forEach( (attribute) -> convertedQuery.add(parseAttribute((String)attribute)))

        ArrayList<Criteria> mongoCriterias = new ArrayList<>()
        convertedQuery.forEach( (attribute) -> mongoCriterias.add(getCriteriaFromAttribute(attribute)))

        Query mongoQuery = new Query();
        mongoCriterias.forEach( (criteria) -> mongoQuery.addCriteria(criteria))

        return mongoQuery.toString()
    }

    private Criteria getCriteriaFromAttribute(final Attribute attribute) {
        switch (attribute.getOperator()) {
            case GTE: return Criteria.where(attribute.getField()).gte(attribute.getValue())
            case LTE: return Criteria.where(attribute.getField()).lte(attribute.getValue())
            case NE: return Criteria.where(attribute.getField()).ne(attribute.getValue())
            case GT: return Criteria.where(attribute.getField()).gt(attribute.getValue())
            case LT: return Criteria.where(attribute.getField()).lt(attribute.getValue())
            case EQ: return Criteria.where(attribute.getField()).is(attribute.getValue())
        }
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
