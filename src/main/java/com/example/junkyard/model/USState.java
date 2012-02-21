package com.example.junkyard.model;
import com.example.junkyard.business.BusinessException;

import java.util.HashMap;
import java.util.Map;

/**
 */
public enum USState {
    ALASKA, ALABAMA, ARKANSAS, ARIZONA, CALIFORNIA, COLORADO, CONNECTICUT, DELAWARE, FLORIDA, GEORGIA,
    HAWAII, IOWA, IDAHO, ILLINOIS, INDIANA, KANSAS, KENTUCKY, LOUISIANA, MASSACHUSETTS, MARYLAND, MAINE,
    MICHIGAN, MINNESOTA, MISSOURI, MISSISSIPPI, MONTANA, NORTH_CAROLINA, NORTH_DAKOTA, NEBRASKA, NEW_HAMPSHIRE,
    NEW_JERSEY, NEW_MEXICO, NEVADA, NEW_YORK, OHIO, OKLAHOMA, OREGON, PENNSYLVANIA, RHODE_ISLAND, SOUTH_CAROLINA,
    SOUTH_DAKOTA, TENNESSEE, TEXAS, UTAH, VIRGINIA, VERMONT, WASHINGTON, WISCONSIN, WEST_VIRGINA, WYOMING;

    private static Map<USState, String> stateCodes = new HashMap<USState, String>() {
        {
            put(ALASKA, "AK");
            put(ALABAMA, "AL");
            put(ARKANSAS, "AK");
            put(ARIZONA, "AZ");
            put(CALIFORNIA, "CA");
            put(COLORADO, "CO");
            put(CONNECTICUT, "CT");
            put(DELAWARE, "DE");
            put(FLORIDA, "FL");
            put(GEORGIA, "GA");
            put(HAWAII, "HI");
            put(IOWA, "IA");
            put(IDAHO, "ID");
            put(ILLINOIS, "IL");
            put(INDIANA, "IN");
            put(KANSAS, "KS");
            put(KENTUCKY, "KY");
            put(LOUISIANA, "LA");
            put(MASSACHUSETTS, "MA");
            put(MARYLAND, "MD");
            put(MAINE, "ME");
            put(MICHIGAN, "MI");
            put(MINNESOTA, "MN");
            put(MISSOURI, "MO");
            put(MISSISSIPPI, "MS");
            put(MONTANA, "MT");
            put(NORTH_CAROLINA, "NC");
            put(NORTH_DAKOTA, "ND");
            put(NEBRASKA, "NE");
            put(NEW_HAMPSHIRE, "NH");
            put(NEW_JERSEY, "NJ");
            put(NEW_MEXICO, "NM");
            put(NEVADA, "NV");
            put(NEW_YORK, "NY");
            put(OHIO, "OH");
            put(OKLAHOMA, "OK");
            put(OREGON, "OR");
            put(PENNSYLVANIA, "PA");
            put(RHODE_ISLAND, "RI");
            put(SOUTH_CAROLINA, "SC");
            put(SOUTH_DAKOTA, "SD");
            put(TENNESSEE, "TN");
            put(TEXAS, "TX");
            put(UTAH, "UT");
            put(VIRGINIA, "VA");
            put(VERMONT, "VT");
            put(WASHINGTON, "WA");
            put(WISCONSIN, "WI");
            put(WEST_VIRGINA, "WV");
            put(WYOMING, "WY");
        }
    };

    public String getStateCode() {
        String code = stateCodes.get(this);

        if (code == null) {
            throw new BusinessException("Unable to find state code for " + this.name());
        }

        return code;
    }

    public USState fromStateCode(String stateCode) {
        for (Map.Entry<USState, String> entry : stateCodes.entrySet()) {
            if (entry.getValue().equals(stateCode.toUpperCase())) {
                return entry.getKey();
            }
        }

        throw new BusinessException("Invalid State Code: " + stateCode);
    }
}
