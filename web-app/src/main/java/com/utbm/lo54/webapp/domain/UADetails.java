package com.utbm.lo54.webapp.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UADetails implements Serializable {
    @SerializedName("grant_type")
    private String grantType;
    private String username;
    private Boolean authenticated;
    private UAPrincipal principal;

    public UADetails(String grantType, String username, Boolean authenticated, UAPrincipal principal) {
        this.grantType = grantType;
        this.username = username;
        this.authenticated = authenticated;
        this.principal = principal;
    }

    public UADetails() {
    }

    @Override
    public String toString() {
        return "UADetails{" +
                "grantType='" + grantType + '\'' +
                ", username='" + username + '\'' +
                ", authenticated=" + authenticated +
                ", principal=" + principal +
                '}';
    }

    public String getGrantType() {
        return grantType;
    }

    public UADetails setGrantType(String grantType) {
        this.grantType = grantType;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UADetails setUsername(String username) {
        this.username = username;
        return this;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public UADetails setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
        return this;
    }

    public UAPrincipal getPrincipal() {
        return principal;
    }

    public UADetails setPrincipal(UAPrincipal principal) {
        this.principal = principal;
        return this;
    }


}
