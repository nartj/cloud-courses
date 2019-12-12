package com.utbm.lo54.webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

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
    @JsonProperty("grant_type")
    @SerializedName("grant_type")
    private String grantType = "client_credentials";


    public UserLoginDto(@NotNull @NotBlank String username, @NotNull @NotBlank String password) {
        this.username = username;
        this.password = password;
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

    @JsonProperty("grant_type")
    public String getGrantType() {
        return grantType;
    }

    @JsonProperty("grant_type")
    public UserLoginDto setGrant_type(String grant_type) {
        this.grantType = grant_type;
        return this;
    }

    @Override
    public String toString() {
        return "UserRegistrationDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", grant_type='" + grantType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLoginDto that = (UserLoginDto) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(password, that.grantType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, grantType);
    }
}
