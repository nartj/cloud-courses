//package com.utbm.lo54.cloudcourseswebapp;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.apache.commons.codec.binary.Base64;
//import org.bouncycastle.i18n.MissingEntryException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.*;
//
//
//@Component
//public class CustomRequestInterceptor implements RequestInterceptor {
//    private static final String BASIC_PREFIX = "Basic ";
//    private final Logger LOG = LoggerFactory.getLogger(CustomRequestInterceptor.class);
//
//    @Value("${security.oauth2.client.clientId}")
//    private String oAuth2ClientId;
//    @Value("${security.oauth2.client.clientSecret}")
//    private String oAuth2ClientSecret;
//
//    @Override
//    public void apply(RequestTemplate template) {
//        LOG.info("Intercepted request : RestTemplate {}", template);
//
////        Boolean isBearer
////        Map<String, Collection<String>> headers = template.headers();
////        for (String key : headers.keySet()) {
////            if (key.toLowerCase().contains("authorization")) {
////                for (String value : headers.get(key)) {
////                    if (value.toLowerCase().contains("basic")) {
////
////                    }
////                }
////            }
////        }
//        if (!template.headers().containsKey(HttpHeaders.AUTHORIZATION)) {
//            if (oAuth2ClientId != null && !oAuth2ClientId.isEmpty()
//                    && oAuth2ClientSecret != null && !oAuth2ClientSecret.isEmpty()) {
//                final byte[] encodedBytes =
//                        Base64.encodeBase64(String.format("%s:%s", oAuth2ClientId, oAuth2ClientSecret).getBytes());
//                LOG.info("Built Credentials {}", BASIC_PREFIX + new String(encodedBytes));
//                template.headers(Collections.singletonMap("Authorization", Collections.singletonList(BASIC_PREFIX + new String(encodedBytes))));
//            }
//        } else {
//            LOG.info("Intercepted request had already a Authorization Header : {}", template.headers().get(HttpHeaders.AUTHORIZATION));
//        }
//
//    }
//}
