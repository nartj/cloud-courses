package com.utbm.lo54.webapp.service.impl;

public class LoginTokenPair {
    private BearerToken accessToken;
    private BearerToken refreshToken;

    public LoginTokenPair(BearerToken accessToken, BearerToken refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public static class BearerToken {
        private String token;
        private String validity;

        public BearerToken(String token, String validity) {
            this.token = token;
            this.validity = validity;
        }

        public String getToken() {
            return token;
        }

        public BearerToken setToken(String token) {
            this.token = token;
            return this;
        }

        public String getValidity() {
            return validity;
        }

        public BearerToken setValidity(String validity) {
            this.validity = validity;
            return this;
        }
    }
}
