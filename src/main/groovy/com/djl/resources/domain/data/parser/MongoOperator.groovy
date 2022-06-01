package com.djl.resources.domain.data.parser

enum MongoOperator {

    EQ("eq","="),
    GT("gt", ">"),
    GTE("gte", ">="),
    LT("lt", "<"),
    LTE("lte", "<="),
    NE("ne","!=")

    private final String mongoOp
    private final String urlOp

    MongoOperator(String mongoOp, String urlOp) {
        this.mongoOp = mongoOp
        this.urlOp = urlOp
    }

    String getMongoOp() {
        return mongoOp
    }

    String getUrlOp() {
        return urlOp
    }

    MongoOperator get(String urlOp) {
        switch (urlOp) {
            case "=": return EQ
            case ">": return GT
            case "<": return LT
            case "!=": return NE
            case ">=": return GTE
            case "<=": return LTE
        }
    }

}