package com.utbm.lo54.webapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableOAuth2Client
public class OAuthConfig {

//    @Value("${security.oauth2.client.clientId}")
//    private String oAuth2ClientId;
//
//    @Value("${security.oauth2.client.clientSecret}")
//    private String oAuth2ClientSecret;
//
    @Value("${security.oauth2.client.accessTokenUri}")
    private String accessTokenUri;

    @Bean
    public RestTemplate oAuthRestTemplate() {
        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        //resourceDetails.setId("1");
        String userName, password;
        if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (principal instanceof UserDetails) {
                userName = ((UserDetails) principal).getUsername();
                password = ((UserDetails) principal).getPassword();
            } else {
                userName = principal.toString();
                password = principal.toString();
            }
        } else {
            userName = "anonymous";
            password = "anonymous";
        }

        resourceDetails.setClientId(userName);
        resourceDetails.setClientSecret(password);
        resourceDetails.setGrantType("password");
        resourceDetails.setAccessTokenUri(accessTokenUri);

    /*

    When using @EnableOAuth2Client spring creates a OAuth2ClientContext for us:

    "The OAuth2ClientContext is placed (for you) in session scope to keep the state for different users separate.
    Without that you would have to manage the equivalent data structure yourself on the server,
    mapping incoming requests to users, and associating each user with a separate instance of the OAuth2ClientContext."
    (http://projects.spring.io/spring-security-oauth/docs/oauth2.html#client-configuration)

    Internally the SessionScope works with a threadlocal to store variables, hence a new thread cannot access those.
    Therefore we can not use @Async

    Solution: create a new OAuth2ClientContext that has no scope.
    *Note: this is only safe when using client_credentials as OAuth grant type!

     */

//        OAuth2RestTemplate restTemplate = new      OAuth2RestTemplate(resourceDetails, oauth2ClientContext);
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, new DefaultOAuth2ClientContext());

        return restTemplate;
    }
}
