package com.utbm.lo54.clientwebapp.service.impl;


import com.utbm.lo54.clientwebapp.repository.UserRepository;
import com.utbm.lo54.clientwebapp.service.UserService;
import com.utbm.lo54.common.domain.security.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
