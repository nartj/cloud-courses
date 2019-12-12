package com.utbm.lo54.common.security;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Config JWT.
 * Only one property 'shuaicj.security.jwt.secret' is mandatory.
 *
 * @author shuaicj 2017/10/18
 */
@Component
public class JwtAuthenticationConfig {

    @Value("${shuaicj.security.jwt.url:/login}")
    private String url;

    @Value("${shuaicj.security.jwt.header:Authorization}")
    private String header;

    @Value("${shuaicj.security.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${shuaicj.security.jwt.expiration:#{24*60*60}}")
    private int expiration; // default 24 hours

    @Value("${shuaicj.security.jwt.secret:lo54}")
    private String secret;

    public JwtAuthenticationConfig() {
    }

    public String getUrl() {
        return url;
    }

    public JwtAuthenticationConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getHeader() {
        return header;
    }

    public JwtAuthenticationConfig setHeader(String header) {
        this.header = header;
        return this;
    }

    public String getPrefix() {
        return prefix;
    }

    public JwtAuthenticationConfig setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public int getExpiration() {
        return expiration;
    }

    public JwtAuthenticationConfig setExpiration(int expiration) {
        this.expiration = expiration;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public JwtAuthenticationConfig setSecret(String secret) {
        this.secret = secret;
        return this;
    }
}
