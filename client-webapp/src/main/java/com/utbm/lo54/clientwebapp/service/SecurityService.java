package com.utbm.lo54.clientwebapp.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String passwordConfirm);
}
