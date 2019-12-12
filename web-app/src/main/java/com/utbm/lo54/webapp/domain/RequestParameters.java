package com.utbm.lo54.webapp.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RequestParameters implements Serializable {
    @SerializedName("grant_type")
    private String grantType;
    private String username;

    public RequestParameters(String grantType, String username) {
        this.grantType = grantType;
        this.username = username;
    }

    public RequestParameters() {
    }

    @Override
    public String toString() {
        return "RequestParameters{" +
                "grantType='" + grantType + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getGrantType() {
        return grantType;
    }

    public RequestParameters setGrantType(String grantType) {
        this.grantType = grantType;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public RequestParameters setUsername(String username) {
        this.username = username;
        return this;
    }
}
