package com.utbm.lo54.common;

public enum ServiceApiEndpoint {
    SAVE("/save"),
    LIST("/all"),
    FIND("/find/"),
    UPDATE("/update/"),
    DELETE("/delete/"),
    FILTER_BY_LOCATION("/all/location/"),
    FILTER_BY_COURSE("/all/course/"),
    FILTER_BY_CLIENT("/all/client/");

    private String endpoint;

    ServiceApiEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
