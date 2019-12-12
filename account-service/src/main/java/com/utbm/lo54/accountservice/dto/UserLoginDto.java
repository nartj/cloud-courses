package com.utbm.lo54.accountservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class UserLoginDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String grant_type;

    public UserLoginDto(@NotNull @NotBlank String username, @NotNull @NotBlank String password, @NotNull @NotBlank String grant_type) {
        this.username = username;
        this.password = password;
        this.grant_type = grant_type;
    }

    public UserLoginDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public UserLoginDto setGrant_type(String grant_type) {
        this.grant_type = grant_type;
        return this;
    }

    @Override
    public String toString() {
        return "UserLoginDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", grant_type='" + grant_type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLoginDto that = (UserLoginDto) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(grant_type, that.grant_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, grant_type);
    }
}
