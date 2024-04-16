package com.example.pr2.models;

import org.springframework.security.core.GrantedAuthority;

public enum roleEnum implements GrantedAuthority {
    USER, ADMIN;
    @Override
    public String getAuthority()
    {
        return name();
    }
}
