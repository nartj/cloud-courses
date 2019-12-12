package com.utbm.lo54.security.service;

import com.utbm.lo54.security.repository.AuthClientRepository;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthClientDetailsService implements ClientDetailsService {
    private final AuthClientRepository authClientRepository;

    public AuthClientDetailsService(AuthClientRepository authClientRepository) {
        this.authClientRepository = authClientRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) {
        return authClientRepository.findByClientId(clientId).orElseThrow(IllegalArgumentException::new);
    }
}
