package com.example.junkyard.domain;

import com.example.junkyard.business.BusinessException;

/**
 */
public enum EmailDestinationSourceType  {

    USER(1), ALIAS(2), GROUP(3);

    private int id;

    EmailDestinationSourceType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static EmailDestinationSourceType valueOf(int id) {
        switch (id) {
            case 1: return USER;
            case 2: return ALIAS;
            case 3: return GROUP;
            default:
                throw new BusinessException("Unhandled EmailDestinationSourceType: " + id);
        }
    }

    public String getErrorMessageDescription() {
        switch (this) {
            case USER:
                return "a user";
            case ALIAS:
                return "an alias";
            case GROUP:
                return "a group";
            default:
                throw new BusinessException("Unhandled EmailDestinationSourceType: " + this);
        }
    }
}
