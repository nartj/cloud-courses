package com.utbm.lo54.clientwebapp.repository;

public interface SecurityRepository {
    String findLoggedInUsername();
    void autoLogin(String username, String password);

}
