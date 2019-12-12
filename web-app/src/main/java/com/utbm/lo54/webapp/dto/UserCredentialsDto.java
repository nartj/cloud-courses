package com.utbm.lo54.webapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class UserCredentialsDto {
    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String password;



    public UserCredentialsDto(@NotNull @NotBlank String username, @NotNull @NotBlank String password) {
        this.username = username;
        this.password = password;
    }

    public UserCredentialsDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserCredentialsDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserCredentialsDto setPassword(String password) {
        this.password = password;
        return this;
    }


    @Override
    public String toString() {
        return "UserRegistrationDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCredentialsDto that = (UserCredentialsDto) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
