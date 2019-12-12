package com.utbm.lo54.webapp.utils;

import java.util.Optional;

public class SecurityApiEndpoint {

    private final SecurityType security;
    private final Endpoint endpoint;
    private final Optional<String> username;

    public enum SecurityType {

        ACCOUNT("accounts"), UAA("uaa");
        private final String type;

        SecurityType(final String type) {
            this.type = type;
        }

        public String getEnpoint() {
            return type;
        }
    }

    public enum Endpoint {

        ALL(""),
        FIND("/"),
        SAVE(""),
        UPDATE(""),
        DELETE("/"),
        CURRENT("/user/current"),
        AUTOLOG("/user/autolog");
        private final String endpoint;

        Endpoint(String endpoint) {
            this.endpoint = endpoint;
        }

        public String getEnpoint() {
            return endpoint;
        }
    }

    public SecurityApiEndpoint(SecurityType security, Endpoint endpoint, Optional<String> username) {
        super();
        this.security = security;
        this.endpoint = endpoint;
        this.username = username;
    }

    public SecurityType getSecurity() {
        return security;
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    public String getUri() {
        return username.map(aUsername -> getSecurity().getEnpoint() + getEndpoint().getEnpoint() + aUsername)
                .orElseGet(() -> getSecurity().getEnpoint() + getEndpoint().getEnpoint());
    }

    public Optional<String> getUsername() {
        return username;
    }
}
