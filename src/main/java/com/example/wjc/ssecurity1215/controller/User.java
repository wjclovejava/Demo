package com.example.wjc.ssecurity1215.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/17 17:43
 */
@Data
@NoArgsConstructor
public class User implements UserDetails {

    private Integer id;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
    /**
     * 权限列表
     */
    private List<GrantedAuthority> authorities;

    public User(String username, String password, List<GrantedAuthority> authorities) {
        this.username=username;
        this.password=password;
        this.authorities=authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * 帐户是否已过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 帐户是否锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用户的凭据（密码）是否已过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是启用还是禁用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
