package com.utbm.lo54.core.users.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

}
