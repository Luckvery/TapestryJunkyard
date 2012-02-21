package com.example.junkyard.domain;

import com.example.junkyard.business.BusinessException;

/**
 */
public enum HeaderCheckType {

    FROM (1), TO (2);

    private int id;

    HeaderCheckType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public static HeaderCheckType valueOf(int id) {
        switch (id) {
            case 1: return FROM;
            case 2: return TO;
            default: throw new BusinessException("Unhandled HeaderCheckTypeId " + id);
        }
    }


}
