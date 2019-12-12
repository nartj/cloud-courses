package com.utbm.lo54.webapp.service;


import com.utbm.lo54.webapp.domain.TokenInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;

public interface UserService {
    Authentication findByUserName(String userName);

    ResponseEntity<TokenInfo> login(Map<String, String> user);

    ResponseEntity<TokenInfo> authenticate(Principal principal) throws IOException;

    ResponseEntity<TokenInfo> authenticate() throws IOException;
}
