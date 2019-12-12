package com.utbm.lo54.webapp.domain;

import java.io.Serializable;
import java.util.Arrays;

public class UserAuthentication implements Serializable {
    private String[] authorities;
    private UADetails details;
    private Boolean authenticated;
    private UAPrincipal principal;
    private String credentials;
    private String name;

    public UserAuthentication(String[] authorities, UADetails details, Boolean authenticated, UAPrincipal principal, String credentials, String name) {
        this.authorities = authorities;
        this.details = details;
        this.authenticated = authenticated;
        this.principal = principal;
        this.credentials = credentials;
        this.name = name;
    }

    public UserAuthentication() {
    }

    @Override
    public String toString() {
        return "UserAuthentication{" +
                "authorities=" + Arrays.toString(authorities) +
                ", details=" + details +
                ", authenticated=" + authenticated +
                ", principal=" + principal +
                ", credentials='" + credentials + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public UserAuthentication setAuthorities(String[] authorities) {
        this.authorities = authorities;
        return this;
    }

    public UADetails getDetails() {
        return details;
    }

    public UserAuthentication setDetails(UADetails details) {
        this.details = details;
        return this;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public UserAuthentication setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
        return this;
    }

    public UAPrincipal getPrincipal() {
        return principal;
    }

    public UserAuthentication setPrincipal(UAPrincipal principal) {
        this.principal = principal;
        return this;
    }

    public String getCredentials() {
        return credentials;
    }

    public UserAuthentication setCredentials(String credentials) {
        this.credentials = credentials;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserAuthentication setName(String name) {
        this.name = name;
        return this;
    }
}
