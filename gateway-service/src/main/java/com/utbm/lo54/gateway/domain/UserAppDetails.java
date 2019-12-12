//package com.utbm.lo54.zuul.domain;
//
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
//@JsonDeserialize(as = UserAppDetails.class)
//public class UserAppDetails implements UserDetails
//{
//
//    private String username;
//    private String password;
//    private Integer active;
//    private boolean isLocked;
//    private boolean isExpired;
//    private boolean isEnabled;
//    private List<GrantedAuthority> grantedAuthorities;
//
//    public UserAppDetails(String username, String password,Integer active, boolean isLocked, boolean isExpired, boolean isEnabled, String [] authorities) {
//        this.username = username;
//        this.password = password;
//        this.active = active;
//        this.isLocked = isLocked;
//        this.isExpired = isExpired;
//        this.isEnabled = isEnabled;
//        this.grantedAuthorities = AuthorityUtils.createAuthorityList(authorities);
//    }
//
//    public UserAppDetails(String username,  String [] authorities) {
//        this.username = username;
//        this.grantedAuthorities = AuthorityUtils.createAuthorityList(authorities);
//    }
//
//    public UserAppDetails() {
//        super();
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return grantedAuthorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return active==1;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return !isLocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return !isExpired;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return isEnabled;
//    }
//
//    public UserAppDetails setPassword(String password) {
//        this.password = password;
//        return this;
//    }
//
//    public UserAppDetails setUsername(String username) {
//        this.username = username;
//        return this;
//    }
//
//    public UserAppDetails setActive(Integer active) {
//        this.active = active;
//        return this;
//    }
//
//    public UserAppDetails setLocked(boolean locked) {
//        isLocked = locked;
//        return this;
//    }
//
//    public UserAppDetails setExpired(boolean expired) {
//        isExpired = expired;
//        return this;
//    }
//
//    public UserAppDetails setEnabled(boolean enabled) {
//        isEnabled = enabled;
//        return this;
//    }
//
//    public UserAppDetails setGrantedAuthorities(List<GrantedAuthority> grantedAuthorities) {
//        this.grantedAuthorities = grantedAuthorities;
//        return this;
//    }
//}