package com.utbm.lo54.webapp.domain;

import java.io.Serializable;
import java.util.Arrays;

public class POAuth2Request implements Serializable {
    private String clientId;
    private String[] scope;
    private RequestParameters requestParameters;
    private String[] resourceIds;
    private String[] authorities;
    private Boolean approved;
    private Boolean refresh;
    private String redirectUri;
    private String[] responseTypes;
    private PExtension extension;
    private String grantType;
    private String refreshTokenRequest;

    public POAuth2Request(String clientId, String[] scope, RequestParameters requestParameters, String[] resourceIds, String[] authorities, Boolean approved, Boolean refresh, String redirectUri, String[] responseTypes, PExtension extension, String grantType, String refreshTokenRequest) {
        this.clientId = clientId;
        this.scope = scope;
        this.requestParameters = requestParameters;
        this.resourceIds = resourceIds;
        this.authorities = authorities;
        this.approved = approved;
        this.refresh = refresh;
        this.redirectUri = redirectUri;
        this.responseTypes = responseTypes;
        this.extension = extension;
        this.grantType = grantType;
        this.refreshTokenRequest = refreshTokenRequest;
    }

    @Override
    public String toString() {
        return "POAuth2Request{" +
                "clientId='" + clientId + '\'' +
                ", scope=" + Arrays.toString(scope) +
                ", requestParameters=" + requestParameters +
                ", resourceIds=" + Arrays.toString(resourceIds) +
                ", authorities=" + Arrays.toString(authorities) +
                ", approved=" + approved +
                ", refresh=" + refresh +
                ", redirectUri='" + redirectUri + '\'' +
                ", responseTypes=" + Arrays.toString(responseTypes) +
                ", extension=" + extension +
                ", grantType='" + grantType + '\'' +
                ", refreshTokenRequest='" + refreshTokenRequest + '\'' +
                '}';
    }

    public POAuth2Request() {
    }

    public String getClientId() {
        return clientId;
    }

    public POAuth2Request setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public String[] getScope() {
        return scope;
    }

    public POAuth2Request setScope(String[] scope) {
        this.scope = scope;
        return this;
    }

    public RequestParameters getRequestParameters() {
        return requestParameters;
    }

    public POAuth2Request setRequestParameters(RequestParameters requestParameters) {
        this.requestParameters = requestParameters;
        return this;
    }

    public String[] getResourceIds() {
        return resourceIds;
    }

    public POAuth2Request setResourceIds(String[] resourceIds) {
        this.resourceIds = resourceIds;
        return this;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public POAuth2Request setAuthorities(String[] authorities) {
        this.authorities = authorities;
        return this;
    }

    public Boolean getApproved() {
        return approved;
    }

    public POAuth2Request setApproved(Boolean approved) {
        this.approved = approved;
        return this;
    }

    public Boolean getRefresh() {
        return refresh;
    }

    public POAuth2Request setRefresh(Boolean refresh) {
        this.refresh = refresh;
        return this;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public POAuth2Request setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    public String[] getResponseTypes() {
        return responseTypes;
    }

    public POAuth2Request setResponseTypes(String[] responseTypes) {
        this.responseTypes = responseTypes;
        return this;
    }

    public PExtension getExtension() {
        return extension;
    }

    public POAuth2Request setExtension(PExtension extension) {
        this.extension = extension;
        return this;
    }

    public String getGrantType() {
        return grantType;
    }

    public POAuth2Request setGrantType(String grantType) {
        this.grantType = grantType;
        return this;
    }

    public String getRefreshTokenRequest() {
        return refreshTokenRequest;
    }

    public POAuth2Request setRefreshTokenRequest(String refreshTokenRequest) {
        this.refreshTokenRequest = refreshTokenRequest;
        return this;
    }
}

