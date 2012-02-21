package com.example.junkyard.domain;
import com.example.junkyard.business.BusinessException;

/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 11/30/11
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */
public enum NetworkType {
  INTERNAL (1), EXTERNAL(2);

    private int id;

    NetworkType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public static NetworkType valueOf(int id) {
        switch (id) {
            case 1: return INTERNAL;
            case 2: return EXTERNAL;
            default: throw new BusinessException("Unhandled NetworkType " + id);
        }

    }


}

