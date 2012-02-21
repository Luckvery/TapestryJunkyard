package com.example.junkyard.searchkeys;


import com.example.junkyard.domain.HeaderCheckType;

import java.io.Serializable;

/**
 */
public class HeaderCheckSearchKeys implements Serializable {

    private HeaderCheckType headerCheckType;
    private String headerCheckFragment;

    public HeaderCheckType getHeaderCheckType() {
        return headerCheckType;
    }

    public void setHeaderCheckType(HeaderCheckType headerCheckType) {
        this.headerCheckType = headerCheckType;
    }

    public String getHeaderCheckFragment() {
        return headerCheckFragment;
    }

    public void setHeaderCheckFragment(String headerCheckFragment) {
        this.headerCheckFragment = headerCheckFragment;
    }
}
