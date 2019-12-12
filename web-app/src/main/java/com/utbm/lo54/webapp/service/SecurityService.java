package com.utbm.lo54.webapp.service;

import com.utbm.lo54.webapp.dto.UserDto;

public interface SecurityService {
    UserDto findLoggedInUsername();

    void autoLogin(String username, String passwordConfirm);


}
