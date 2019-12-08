package com.utbm.lo54.clientwebapp.service.impl;

import com.utbm.lo54.clientwebapp.repository.SecurityRepository;
import com.utbm.lo54.clientwebapp.repository.impl.SecurityRepositoryImpl;
import com.utbm.lo54.clientwebapp.service.SecurityService;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {
    final static Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    @Autowired
    private SecurityRepositoryImpl securityRepository;

    public String findLoggedInUsername() {
        logger.debug("Getting logged in user");
        return securityRepository.findLoggedInUsername();
    }

    @Override
    public void autoLogin(String username, String passwordConfirm) {
        logger.debug("Auto logging {}", username);
        securityRepository.autoLogin(username, passwordConfirm);
    }
}
