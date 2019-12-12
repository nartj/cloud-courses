//package com.utbm.lo54.gateway;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
//import javax.annotation.Resource;
//
//@Configuration
//@EnableAuthorizationServer
//public class SecurityOAuth2Configuration extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//        oauthServer.tokenKeyAccess("permitAll()")
//                .checkTokenAccess("isAuthenticated()");
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("anonymous")
//                .secret("{noop}anonymous")
//                .accessTokenValiditySeconds(2000)
//                .refreshTokenValiditySeconds(-1)
//                .scopes("read")
//                .authorizedGrantTypes("password", "refresh_token")
//            .and()
//                .withClient("professor")
//                .secret("{noop}professor")
//                .accessTokenValiditySeconds(2000)
//                .refreshTokenValiditySeconds(-1)
//                .scopes("read", "professor")
//                .authorizedGrantTypes("password", "refresh_token")
//            .and()
//                .withClient("admin")
//                .secret("{noop}admin")
//                .accessTokenValiditySeconds(2000)
//                .refreshTokenValiditySeconds(-1)
//                .scopes("read", "write")
//                .authorizedGrantTypes("password", "refresh_token");
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(authenticationManager);
//    }
//
//}
//
