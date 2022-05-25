package com.myz.azloanmanage.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Data
public class SysUser implements UserDetails {
    private Long id;

    private String userName;

    private String password;

    private String nickName;

    private Byte rights;

    private Byte status;

    private String openId;

    private Date createTime;

    private Date updateTime;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
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
        if (status==0) {
            return true;
        }else {
            return false;
        }
    }
}