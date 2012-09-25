package com.example.junkyard.domain.reference;


public class USStateList {

    public final static String STATE_CODE_MAP[][] = {
            {"Alabama", "AL"},
            {"Alaska", "AK"},
            //       			{"American Samoa", "AS"},
            {"Arizona", "AZ"},
            {"Arkansas", "AR"},
            {"California", "CA"},
            {"Colorado", "CO"},
            {"Connecticut", "CT"},
            {"Delaware", "DE"},
            {"Dist. of Columbia", "DC"},
            //       			{"FS of Micronesia", "FM"},
            {"Florida", "FL"},
            {"Georgia", "GA"},
            //       			{"Guam", "GU"},
            {"Hawaii", "HI"},
            {"Idaho", "ID"},
            {"Illinois", "IL"},
            {"Indiana", "IN"},
            {"Iowa", "IA"},
            {"Kansas", "KS"},
            {"Kentucky", "KY"},
            {"Louisiana", "LA"},
            {"Maine", "ME"},
            //       			{"Marshall Islands", "MH"},
            {"Maryland", "MD"},
            {"Massachusetts", "MA"},
            {"Michigan", "MI"},
            {"Minnesota", "MN"},
            {"Mississippi", "MS"},
            {"Missouri", "MO"},
            {"Montana", "MT"},
            {"Nebraska", "NE"},
            {"Nevada", "NV"},
            {"New Hampshire", "NH"},
            {"New Jersey", "NJ"},
            {"New Mexico", "NM"},
            {"New York", "NY"},
            {"North Carolina", "NC"},
            {"North Dakota", "ND"},
            //       			{"N. Mariana Islands", "MP"},
            {"Ohio", "OH"},
            {"Oklahoma", "OK"},
            {"Oregon", "OR"},
            //       			{"Palau", "PW"},
            {"Pennsylvania", "PA"},
            //       			{"Puerto Rico", "PR"},
            {"Rhode Island", "RI"},
            {"South Carolina", "SC"},
            {"South Dakota", "SD"},
            {"Tennessee", "TN"},
            {"Texas", "TX"},
            {"Utah", "UT"},
            {"Vermont", "VT"},
            //       			{"Virgin Islands", "VI"},
            {"Virginia", "VA"},
            {"Washington", "WA"},
            {"West Virginia", "WV"},
            {"Wisconsin", "WI"},
            {"Wyoming", "WY"}
    };

    public USStateList() {
    }

    public static int getSize() {
        return STATE_CODE_MAP.length;
    }

    public static String getNameFromInt(final int i) {
        return STATE_CODE_MAP[i][0];
    }

    public static String getCodeFromInt(final int i) {
        return STATE_CODE_MAP[i][1];
    }

    public static String getNameFromCode(String stateCode) {
        if (stateCode == null) return "";
        stateCode = stateCode.trim();

        for (int i = 0; i < getSize(); i++) {
            if (stateCode.equals(STATE_CODE_MAP[i][1])) return STATE_CODE_MAP[i][0];
        }

        return "";
    }

}
