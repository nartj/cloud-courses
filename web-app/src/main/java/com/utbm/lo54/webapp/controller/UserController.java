package com.utbm.lo54.webapp.controller;

import com.utbm.lo54.webapp.CustomAuthenticationProvider;
import com.utbm.lo54.webapp.domain.TokenInfo;
import com.utbm.lo54.webapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;

@Controller
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @Value("${security.oauth2.client.accessTokenUri}")
    private String accessTokenUri;

//    @PostMapping("/authenticate")
//    public void addBearerTokenToHeader(Principal principal) {
//        logger.info("Principal {}", principal);
//    }

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        logger.info(getPrincipal());
        return "welcome";
    }

    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.GET)
    public ResponseEntity<TokenInfo> loginPage(Principal principal) throws IOException {
        logger.info("Principal {}", principal);
////        Authentication authentication = authenticationProvider.authenticate((Authentication)principal);
////        logger.info("Provided Authentication{}", authentication);
////        logger.info("Principal {}", authentication.getPrincipal());
//////        UserDetails current = (UserDetails)authentication.getPrincipal();
//////        logger.info("Password {}", current.getPassword());
////        userService.login(new UserLoginDto((String)authentication.getPrincipal(), (String)authentication.getCredentials()));
//////        model.addAttribute("user", current.getUsername());
//        HttpHeaders httpHeaders = oAuthRestTemplate.headForHeaders(accessTokenUri);
//        UserLoginDto user = new UserLoginDto("user", "user");
//        HttpEntity<String> request =
//                new HttpEntity<>(user.toString(), httpHeaders);
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<String> responseEntityStr = oAuthRestTemplate.
//                postForEntity(accessTokenUri, request, String.class);
//
//        if (responseEntityStr.getBody() != null) {
//            try {
//                JsonNode root = objectMapper.readTree(responseEntityStr.getBody());
//                TokenInfo tokenInfo = new TokenInfo(
//                        root.findValue("access_token").asText(),
//                        root.findValue("token_type").asText(),
//                        root.findValue("refresh_token").asText(),
//                        root.findValue("expires_in").asInt(),
//                        root.findValue("scope").asText());
//                logger.info("Token {}", tokenInfo);
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        }

        return userService.authenticate(principal);
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public TokenInfo authenticate(@RequestParam Map<String, String> user) {
//        logger.info("User auth temptative for {}", user);
//        if(user == null) {
//            throw new IllegalArgumentException("Password not provided");
//        }
//        UserLoginDto userLoginDto = new UserLoginDto(user.get("username"), user.get("password"));
//        ResponseEntity<TokenInfo> tokenInfo = userService.login(user);
//        logger.info("Retrieved token {} for {}", tokenInfo, user);
//        return tokenInfo.getBody();
//    }

//    @GetMapping(value = "/login")
//    public ResponseEntity<TokenInfo> authenticate(Principal principal) throws IOException {
//        return loginPage(principal);
//    }

    @GetMapping("/login")
    private String login(Principal principal) {
        logger.info("Logged principal {}", principal);
        return "welcome";

    }

    private String getPrincipal(){
        String userName = null;

        if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (principal instanceof UserDetails) {
                logger.info("Principal username from UserDetails");
                userName = ((UserDetails) principal).getUsername();
            } else {
                logger.info("Principal was the username String");
                userName = principal.toString();
            }
            return userName;
        } else {
            logger.info("Fallback to anonymous user");
            return "anonymousUser";
        }
    }
}