package com.utbm.lo54.webapp.domain;

import java.io.Serializable;

public class Details implements Serializable {
    private String remoteAddress;
    private String sessionId;
    private String tokenValue;
    private String tokenType;
    private String decodedDetails;

    public Details(String remoteAddress, String sessionId, String tokenValue, String tokenType, String decodedDetails) {
        this.remoteAddress = remoteAddress;
        this.sessionId = sessionId;
        this.tokenValue = tokenValue;
        this.tokenType = tokenType;
        this.decodedDetails = decodedDetails;
    }

    public Details() {

    }

    @Override
    public String toString() {
        return "Details{" +
                "remoteAddress='" + remoteAddress + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", tokenValue='" + tokenValue + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", decodedDetails='" + decodedDetails + '\'' +
                '}';
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public Details setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
        return this;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Details setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public Details setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
        return this;
    }

    public String getTokenType() {
        return tokenType;
    }

    public Details setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public String getDecodedDetails() {
        return decodedDetails;
    }

    public Details setDecodedDetails(String decodedDetails) {
        this.decodedDetails = decodedDetails;
        return this;
    }
}
