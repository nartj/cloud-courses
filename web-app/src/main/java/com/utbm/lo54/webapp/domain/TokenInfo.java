package com.utbm.lo54.webapp.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;


public class TokenInfo implements Serializable {
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("refresh_token")
    private String refreshToken;
    @SerializedName("expires_in")
    private Integer expiresIn;
    @SerializedName("scope")
    private String scope;

    public TokenInfo(String accessToken, String tokenType, String refreshToken, Integer expiresIn, String scope) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
        this.scope = scope;
    }

    public TokenInfo() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public TokenInfo setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getTokenType() {
        return tokenType;
    }

    public TokenInfo setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public TokenInfo setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public TokenInfo setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public TokenInfo setScope(String scope) {
        this.scope = scope;
        return this;
    }

    @Override
    public String toString() {
        return "TokenInfo{" +
                "accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", expiresIn='" + expiresIn + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenInfo tokenInfo = (TokenInfo) o;
        return Objects.equals(accessToken, tokenInfo.accessToken) &&
                Objects.equals(tokenType, tokenInfo.tokenType) &&
                Objects.equals(refreshToken, tokenInfo.refreshToken) &&
                Objects.equals(expiresIn, tokenInfo.expiresIn) &&
                Objects.equals(scope, tokenInfo.scope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, tokenType, refreshToken, expiresIn, scope);
    }
}
