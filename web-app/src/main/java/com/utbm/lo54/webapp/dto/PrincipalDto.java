package com.utbm.lo54.webapp.dto;

import com.utbm.lo54.webapp.domain.Details;
import com.utbm.lo54.webapp.domain.POAuth2Request;
import com.utbm.lo54.webapp.domain.PPrincipal;
import com.utbm.lo54.webapp.domain.UserAuthentication;

import java.io.Serializable;
import java.util.Arrays;

public class PrincipalDto implements Serializable {
    private String[] authorities;
    private Details details;
    private Boolean authenticated;
    private UserAuthentication userAuthentication;
    private String credentials;
    private PPrincipal principal;
    private POAuth2Request oauth2Request;
    private Boolean clientOnly;
    private String name;

    public PrincipalDto(String[] authorities, Details details, Boolean authenticated, UserAuthentication userAuthentication, String credentials, PPrincipal principal, POAuth2Request oauth2Request, Boolean clientOnly, String name) {
        this.authorities = authorities;
        this.details = details;
        this.authenticated = authenticated;
        this.userAuthentication = userAuthentication;
        this.credentials = credentials;
        this.principal = principal;
        this.oauth2Request = oauth2Request;
        this.clientOnly = clientOnly;
        this.name = name;
    }

    public PrincipalDto() {
    }

    @Override
    public String toString() {
        return "PrincipalDto{" +
                "authorities=" + Arrays.toString(authorities) +
                ", details=" + details +
                ", authenticated=" + authenticated +
                ", userAuthentication=" + userAuthentication +
                ", credentials='" + credentials + '\'' +
                ", principal=" + principal +
                ", oauth2Request=" + oauth2Request +
                ", clientOnly=" + clientOnly +
                ", name='" + name + '\'' +
                '}';
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public PrincipalDto setAuthorities(String[] authorities) {
        this.authorities = authorities;
        return this;
    }

    public Details getDetails() {
        return details;
    }

    public PrincipalDto setDetails(Details details) {
        this.details = details;
        return this;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public PrincipalDto setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
        return this;
    }

    public UserAuthentication getUserAuthentication() {
        return userAuthentication;
    }

    public PrincipalDto setUserAuthentication(UserAuthentication userAuthentication) {
        this.userAuthentication = userAuthentication;
        return this;
    }

    public String getCredentials() {
        return credentials;
    }

    public PrincipalDto setCredentials(String credentials) {
        this.credentials = credentials;
        return this;
    }

    public PPrincipal getPrincipal() {
        return principal;
    }

    public PrincipalDto setPrincipal(PPrincipal principal) {
        this.principal = principal;
        return this;
    }

    public POAuth2Request getOauth2Request() {
        return oauth2Request;
    }

    public PrincipalDto setOauth2Request(POAuth2Request oauth2Request) {
        this.oauth2Request = oauth2Request;
        return this;
    }

    public Boolean getClientOnly() {
        return clientOnly;
    }

    public PrincipalDto setClientOnly(Boolean clientOnly) {
        this.clientOnly = clientOnly;
        return this;
    }

    public String getName() {
        return name;
    }

    public PrincipalDto setName(String name) {
        this.name = name;
        return this;
    }
}
