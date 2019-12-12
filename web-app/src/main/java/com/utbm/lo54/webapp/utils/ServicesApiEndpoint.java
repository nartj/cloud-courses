package com.utbm.lo54.webapp.utils;

import java.util.Optional;

public final class ServicesApiEndpoint {

    private final ServiceType service;
    private final Endpoint endpoint;
    private final Optional<Long> id;

    public enum ServiceType {

        CLIENT("clients"), LOCATION("locations"), COURSE_SESSION("course-sessions"), COURSE("courses"), USERS("courses");
        private final String type;

        ServiceType(final String type) {
            this.type = type;
        }

        public String getEnpoint() {
            return "/api/" + type;
        }
    }

    public enum Endpoint {

        ALL(""),
        FIND("/"),
        SAVE(""),
        UPDATE(""),
        DELETE("/"),
        FIND_BY_LOCATION("/location/"),
        FIND_BY_COURSE("/course/"),
        FIND_BY_CLIENT("/client/");
        private final String endpoint;

        Endpoint(String endpoint) {
            this.endpoint = endpoint;
        }

        public String getEnpoint() {
            return endpoint;
        }
    }

    public ServicesApiEndpoint(ServiceType service, Endpoint endpoint, Optional<Long> id) {
        super();
        this.service = service;
        this.endpoint = endpoint;
        this.id = id;
    }

    public ServiceType getService() {
        return service;
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    public Optional<Long> getId() {
        return id;
    }

    public String getUri() {
        return id.map(aLong -> getService().getEnpoint() + getEndpoint().getEnpoint() + aLong)
                .orElseGet(() -> getService().getEnpoint() + getEndpoint().getEnpoint());
    }

}