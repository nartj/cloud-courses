package com.utbm.lo54.core.courses.utils;

public enum ServiceApiEndpoint {
    SAVE("/api/save"),
    LIST("/api/list"),
    FIND("/api/find/"),
    UPDATE("/api/update/"),
    DELETE("/api/delete/"),
    FILTER_BY_LOCATION("/api/list/location/"),
    FILTER_BY_COURSE("/api/list/course/"),
    FILTER_BY_CLIENT("/api/list/client/");

    private String endpoint;

    ServiceApiEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
