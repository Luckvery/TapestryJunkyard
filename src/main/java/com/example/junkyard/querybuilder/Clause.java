package com.example.junkyard.querybuilder;



/**
 * Simple enum to specify query fragment types
 */
public enum Clause {
    SELECT, FROM, JOIN, WHERE, GROUPBY, HAVING, ORDERBY;

    public String conjunctor() {
        switch (this) {
            case SELECT:
            case FROM:
            case GROUPBY:
            case ORDERBY:
                return ", ";
            case JOIN:
                return " join ";
            case WHERE:
            case HAVING:
                return " and ";
        }

        return null;
    }

    public String beginClause() {
        switch (this) {
            case SELECT:
                return "select";
            case FROM:
                return "from";
            case JOIN:
                return "join";
            case WHERE:
                return "where";
            case GROUPBY:
                return "group by";
            case HAVING:
                return "having";
            case ORDERBY:
                return "order by";
        }

        return null;
    }
}