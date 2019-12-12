package com.utbm.lo54.webapp.service.impl;


import com.utbm.lo54.webapp.domain.TokenInfo;
import com.utbm.lo54.webapp.service.UserService;
import com.utbm.lo54.webapp.service.feign.GatewayServiceFeignClient;
import com.utbm.lo54.webapp.utils.JsonFeignResponseHelper;
import feign.codec.Decoder;
import feign.gson.GsonDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final int refreshTokenValiditySeconds = 60 * 60 * 24 * 30;
    private JsonFeignResponseHelper feignHelper;
    private final GatewayServiceFeignClient gatewayServiceFeignClient;
    private final UserDetailsService userDetailsService;
    private final RestTemplate oAuthRestTemplate;

    public UserServiceImpl(GatewayServiceFeignClient gatewayServiceFeignClient, UserDetailsService userDetailsService, RestTemplate oAuthRestTemplate) {
        this.gatewayServiceFeignClient = gatewayServiceFeignClient;
        this.userDetailsService = userDetailsService;
        this.oAuthRestTemplate = oAuthRestTemplate;
    }

    @Override
    public Authentication findByUserName(String userName) {
        UserDetails user = userDetailsService.loadUserByUsername(userName);
        logger.info("UserServiceDetails returned User {}", user);
        return new UsernamePasswordAuthenticationToken(userName, user.getPassword(), new ArrayList<>(user.getAuthorities())) {
            private static final long serialVersionUID = 1L;
            public Object getPrincipal() {
                return user;
            }
        };
    }
//
//    @Override
//    public UserDto save(UserRegistrationDto user) {
//        UserCredentialsDto userCredentialsDto = new UserCredentialsDto(user.getUsername(), user.getPassword());
//        return gatewayServiceFeignClient.createUser(userCredentialsDto);
//    }

    @Override
    public ResponseEntity<TokenInfo> login(Map<String, String> user) {
        logger.info("Preparing user {} request for token.", user);
//        Response response = authServiceFeignClient.login(form);
//        logger.info("Token Info Response : {}", response.body().toString());

        try {
            Decoder.Default decoder = new Decoder.Default();
            String body = (String) decoder.decode(gatewayServiceFeignClient.login(user), String.class);
            logger.info("Feign response body : {}", body);
            GsonDecoder gsonDecoder = new GsonDecoder();
            TokenInfo tokenInfo = (TokenInfo) gsonDecoder.decode(gatewayServiceFeignClient.authenticate(), TokenInfo.class);
//            logger.info("Token Info decoded Response : {}", body);
//            ObjectMapper objectMapper = new ObjectMapper();
//            TokenInfo tokenInfo = objectMapper.readValue(body, TokenInfo.class);
            logger.info("Final TokenInfo : {}", tokenInfo);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            return new ResponseEntity<>(
                    tokenInfo, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<TokenInfo> authenticate(Principal principal) throws IOException {
//        GsonDecoder gsonDecoder = new GsonDecoder();
//        TokenInfo tokenInfo = (TokenInfo) gsonDecoder.decode(gatewayServiceFeignClient.authenticate(), TokenInfo.class);
////            logger.info("Token Info decoded Response : {}", body);
////            ObjectMapper objectMapper = new ObjectMapper();
////            TokenInfo tokenInfo = objectMapper.readValue(body, TokenInfo.class);
//        logger.info("Final TokenInfo : {}", tokenInfo);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//        return new ResponseEntity<>(
//                tokenInfo, headers, HttpStatus.OK);
        logger.info("Principal avant requete {}", principal);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("username", "professor");
        map.add("password", "professor");
        map.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> response = oAuthRestTemplate.postForEntity( "http://localhost:8081/oauth/token", request , String.class );
        logger.info(response.toString());
        GsonDecoder gsonDecoder = new GsonDecoder();
        TokenInfo tokenInfo = (TokenInfo) gsonDecoder.decode(gatewayServiceFeignClient.authenticate(), TokenInfo.class);
        logger.info(tokenInfo.toString());
        return ResponseEntity.ok(tokenInfo);
    }

    @Override
    public ResponseEntity<TokenInfo> authenticate() throws IOException {
        GsonDecoder gsonDecoder = new GsonDecoder();
        TokenInfo tokenInfo = (TokenInfo) gsonDecoder.decode(gatewayServiceFeignClient.authenticate(), TokenInfo.class);
//            logger.info("Token Info decoded Response : {}", body);
//            ObjectMapper objectMapper = new ObjectMapper();
//            TokenInfo tokenInfo = objectMapper.readValue(body, TokenInfo.class);
        logger.info("Final TokenInfo : {}", tokenInfo);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return new ResponseEntity<>(
                tokenInfo, headers, HttpStatus.OK);
    }
}
