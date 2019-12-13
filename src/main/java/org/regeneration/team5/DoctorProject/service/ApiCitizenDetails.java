package org.regeneration.team5.DoctorProject.service;

import org.regeneration.team5.DoctorProject.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class ApiCitizenDetails implements UserDetails {
    private final String amka;
    private final String email;
    private final String mobile;
    private final User user;

    public ApiCitizenDetails(String amka, String email, String mobile, User user) {
        this.amka = amka;
        this.email = email;
        this.mobile = mobile;
        this.user = user;
    }

    public String getAmka() {
        return amka;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
        return true;
    }
}
