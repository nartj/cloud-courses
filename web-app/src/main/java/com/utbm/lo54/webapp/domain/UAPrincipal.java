package com.utbm.lo54.webapp.domain;

import java.io.Serializable;
import java.util.Arrays;

public class UAPrincipal implements Serializable {
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

    public UAPrincipal(String id, String username, String password, Boolean activated, String activationKey, String resetPasswordKey, String[] authorities, Boolean enabled, String accountNonExpired, String accountNonLocked, String credentialsNonExpired) {
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

    public UAPrincipal() {
    }

    @Override
    public String toString() {
        return "UAPrincipal{" +
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

    public UAPrincipal setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UAPrincipal setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UAPrincipal setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean getActivated() {
        return activated;
    }

    public UAPrincipal setActivated(Boolean activated) {
        this.activated = activated;
        return this;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public UAPrincipal setActivationKey(String activationKey) {
        this.activationKey = activationKey;
        return this;
    }

    public String getResetPasswordKey() {
        return resetPasswordKey;
    }

    public UAPrincipal setResetPasswordKey(String resetPasswordKey) {
        this.resetPasswordKey = resetPasswordKey;
        return this;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public UAPrincipal setAuthorities(String[] authorities) {
        this.authorities = authorities;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public UAPrincipal setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getAccountNonExpired() {
        return accountNonExpired;
    }

    public UAPrincipal setAccountNonExpired(String accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
        return this;
    }

    public String getAccountNonLocked() {
        return accountNonLocked;
    }

    public UAPrincipal setAccountNonLocked(String accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
        return this;
    }

    public String getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public UAPrincipal setCredentialsNonExpired(String credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
        return this;
    }
}
