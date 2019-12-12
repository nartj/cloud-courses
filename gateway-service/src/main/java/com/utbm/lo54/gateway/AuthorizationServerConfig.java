package com.utbm.lo54.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@Order(2)
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("anonymous")
                .secret("{noop}anonymous")
                .accessTokenValiditySeconds(2000)
                .refreshTokenValiditySeconds(-1)
                .scopes("read")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .and()
                .withClient("professor")
                .secret("{noop}professor")
                .accessTokenValiditySeconds(2000)
                .refreshTokenValiditySeconds(-1)
                .scopes("read", "professor")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .and()
                .withClient("admin")
                .secret("{noop}admin")
                .accessTokenValiditySeconds(2000)
                .refreshTokenValiditySeconds(-1)
                .scopes("read", "write")
                .authorizedGrantTypes("client_credentials", "refresh_token");
    }
}
