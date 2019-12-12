//package com.utbm.lo54.cloudcourseswebapp;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
//import org.springframework.security.oauth2.client.OAuth2ClientContext;
//import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
//import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
//import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
//
//@Configuration
//public class OAuth2RequestInterceptorConfiguration {
//
//    @Value("${security.oauth2.client.accessTokenUri}")
//    private String accessTokenUri;
//    @Value("${security.oauth2.client.clientId}")
//    private String clientId;
//    @Value("${security.oauth2.client.clientSecret}")
//    private String clientSecret;
//    @Value("${security.oauth2.client.grantType}")
//    private String grantType;
//
//    @Bean
//    public OAuth2FeignRequestInterceptor requestInterceptor() {
//        OAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
//        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
//        resourceDetails.setAccessTokenUri(accessTokenUri);
//        resourceDetails.setClientId(clientId);
//        resourceDetails.setClientSecret(clientSecret);
//        resourceDetails.setGrantType(grantType);
//        return new OAuth2FeignRequestInterceptor(clientContext, resourceDetails);
//    }
//
//    @Bean
//    public OAuth2FeignRequestInterceptor requestInterceptor() {
//        OAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
//        OAuth2ProtectedResourceDetails resourceDetails =
//                new ResourceOwnerPasswordResourceDetails();
//        resourceDetails.setUsername("username");
//        resourceDetails.setPassword("password");
//        return new OAuth2FeignRequestInterceptor(clientContext, resourceDetails);
//    }
//}
