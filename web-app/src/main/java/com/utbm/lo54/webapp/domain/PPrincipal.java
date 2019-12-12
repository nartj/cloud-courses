package com.utbm.lo54.webapp.domain;

import java.io.Serializable;
import java.util.Arrays;

public class PPrincipal implements Serializable {
    private String id;
    private String username;
    private String password;
    private Boolean activated;
    private String activationKey;
    private String resetPasswordKey;
    private String[] authorities;
    private Boolean enabled;
    private String accountNonExpired;
    private String accountNonLocked;
    private String credentialsNonExpired;

    public PPrincipal(String id, String username, String password, Boolean activated, String activationKey, String resetPasswordKey, String[] authorities, Boolean enabled, String accountNonExpired, String accountNonLocked, String credentialsNonExpired) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.activated = activated;
        this.activationKey = activationKey;
        this.resetPasswordKey = resetPasswordKey;
        this.authorities = authorities;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public PPrincipal() {
    }

    @Override
    public String toString() {
        return "PPrincipal{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", activated=" + activated +
                ", activationKey='" + activationKey + '\'' +
                ", resetPasswordKey='" + resetPasswordKey + '\'' +
                ", authorities=" + Arrays.toString(authorities) +
                ", enabled=" + enabled +
                ", accountNonExpired='" + accountNonExpired + '\'' +
                ", accountNonLocked='" + accountNonLocked + '\'' +
                ", credentialsNonExpired='" + credentialsNonExpired + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public PPrincipal setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public PPrincipal setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PPrincipal setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean getActivated() {
        return activated;
    }

    public PPrincipal setActivated(Boolean activated) {
        this.activated = activated;
        return this;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public PPrincipal setActivationKey(String activationKey) {
        this.activationKey = activationKey;
        return this;
    }

    public String getResetPasswordKey() {
        return resetPasswordKey;
    }

    public PPrincipal setResetPasswordKey(String resetPasswordKey) {
        this.resetPasswordKey = resetPasswordKey;
        return this;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public PPrincipal setAuthorities(String[] authorities) {
        this.authorities = authorities;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public PPrincipal setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getAccountNonExpired() {
        return accountNonExpired;
    }

    public PPrincipal setAccountNonExpired(String accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
        return this;
    }

    public String getAccountNonLocked() {
        return accountNonLocked;
    }

    public PPrincipal setAccountNonLocked(String accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
        return this;
    }

    public String getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public PPrincipal setCredentialsNonExpired(String credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
        return this;
    }
}
