//package com.utbm.lo54.accountservice.dto;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//public class TokenInfo implements Serializable {
//    @JsonProperty("access_token")
//    private String accessToken;
//    @JsonProperty("token_type")
//    private String tokenType;
//    @JsonProperty("refresh_token")
//    private String refreshToken;
//    @JsonProperty("expires_in")
//    private String expiresIn;
//    @JsonProperty("scope")
//    private String scope;
//
//    public TokenInfo(String accessToken, String tokenType, String refreshToken, String expiresIn, String scope) {
//        this.accessToken = accessToken;
//        this.tokenType = tokenType;
//        this.refreshToken = refreshToken;
//        this.expiresIn = expiresIn;
//        this.scope = scope;
//    }
//
//    public TokenInfo() {
//    }
//
//    public String getAccessToken() {
//        return accessToken;
//    }
//
//    public TokenInfo setAccessToken(String accessToken) {
//        this.accessToken = accessToken;
//        return this;
//    }
//
//    public String getTokenType() {
//        return tokenType;
//    }
//
//    public TokenInfo setTokenType(String tokenType) {
//        this.tokenType = tokenType;
//        return this;
//    }
//
//    public String getRefreshToken() {
//        return refreshToken;
//    }
//
//    public TokenInfo setRefreshToken(String refreshToken) {
//        this.refreshToken = refreshToken;
//        return this;
//    }
//
//    public String getExpiresIn() {
//        return expiresIn;
//    }
//
//    public TokenInfo setExpiresIn(String expiresIn) {
//        this.expiresIn = expiresIn;
//        return this;
//    }
//
//    public String getScope() {
//        return scope;
//    }
//
//    public TokenInfo setScope(String scope) {
//        this.scope = scope;
//        return this;
//    }
//
//    @Override
//    public String toString() {
//        return "TokenInfo{" +
//                "accessToken='" + accessToken + '\'' +
//                ", tokenType='" + tokenType + '\'' +
//                ", refreshToken='" + refreshToken + '\'' +
//                ", expiresIn='" + expiresIn + '\'' +
//                ", scope='" + scope + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TokenInfo tokenInfo = (TokenInfo) o;
//        return Objects.equals(accessToken, tokenInfo.accessToken) &&
//                Objects.equals(tokenType, tokenInfo.tokenType) &&
//                Objects.equals(refreshToken, tokenInfo.refreshToken) &&
//                Objects.equals(expiresIn, tokenInfo.expiresIn) &&
//                Objects.equals(scope, tokenInfo.scope);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(accessToken, tokenType, refreshToken, expiresIn, scope);
//    }
//}
