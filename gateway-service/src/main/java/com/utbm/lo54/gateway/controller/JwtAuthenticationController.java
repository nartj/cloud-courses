//package com.utbm.lo54.zuul.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//import com.utbm.lo54.zuul.domain.JwtRequest;
//import com.utbm.lo54.zuul.domain.JwtResponse;
//import com.utbm.lo54.zuul.security.JwtTokenUtils;
//import com.utbm.lo54.zuul.service.JwtUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@CrossOrigin
//public class JwtAuthenticationController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenUtils jwtTokenUtil;
//
//    @Autowired
//    private JwtUserDetailsService userDetailsService;
//
//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
//        JwtRequest authenticationRequest = new JwtRequest(username, password);
//        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//        final UserDetails userDetails = userDetailsService
//                .loadUserByUsername(authenticationRequest.getUsername());
//
//        final String token = jwtTokenUtil.generateToken(userDetails);
//        HttpHeaders headers = new HttpHeaders();
//        List<String> headerList = new ArrayList<>();
//        List<String> exposeList = new ArrayList<>();
//        headerList.add("Content-Type");
//        headerList.add(" Accept");
//        headerList.add("X-Requested-With");
//        headerList.add("Authorization");
//        headers.setAccessControlAllowHeaders(headerList);
//        exposeList.add("Authorization");
//        headers.setAccessControlExposeHeaders(exposeList);
//        headers.set("Authorization", token);
//        return new ResponseEntity<>(new JwtResponse(token), headers, HttpStatus.CREATED);
//    }
//
//    private void authenticate(String username, String password) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }
//}
