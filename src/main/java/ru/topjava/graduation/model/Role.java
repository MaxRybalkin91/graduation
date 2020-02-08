package ru.topjava.graduation.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, OWNER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}