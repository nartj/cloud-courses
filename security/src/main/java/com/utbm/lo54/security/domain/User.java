package com.utbm.lo54.security.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Document
public class User implements UserDetails {
    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String password;

    private boolean activated;

    private String activationKey;

    private String resetPasswordKey;

    private Set<Authorities> authorities = new HashSet<>();

    public User(String id, String username, String password, boolean activated, String activationKey, String resetPasswordKey, Set<Authorities> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.activated = activated;
        this.activationKey = activationKey;
        this.resetPasswordKey = resetPasswordKey;
        this.authorities = authorities;
    }

    public User(String username, String password, boolean activated, String activationKey, String resetPasswordKey, Set<Authorities> authorities) {
        this.username = username;
        this.password = password;
        this.activated = activated;
        this.activationKey = activationKey;
        this.resetPasswordKey = resetPasswordKey;
        this.authorities = authorities;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activated;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isActivated() {
        return activated;
    }

    public User setActivated(boolean activated) {
        this.activated = activated;
        return this;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public User setActivationKey(String activationKey) {
        this.activationKey = activationKey;
        return this;
    }

    public String getResetPasswordKey() {
        return resetPasswordKey;
    }

    public User setResetPasswordKey(String resetPasswordKey) {
        this.resetPasswordKey = resetPasswordKey;
        return this;
    }

    @Override
    public Set<Authorities> getAuthorities() {
        return authorities;
    }

    public User setAuthorities(Set<Authorities> authorities) {
        this.authorities = authorities;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", activated=" + activated +
                ", activationKey='" + activationKey + '\'' +
                ", resetPasswordKey='" + resetPasswordKey + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return activated == user.activated &&
                Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(activationKey, user.activationKey) &&
                Objects.equals(resetPasswordKey, user.resetPasswordKey) &&
                Objects.equals(authorities, user.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, activated, activationKey, resetPasswordKey, authorities);
    }
}
