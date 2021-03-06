package com.myz.azloanmanage.service;

import com.myz.azloanmanage.entity.SysUser;

public interface SysUserService {



    /**
     * 根据用户名获取用户对象
     * @param id
     * @return
     */
     SysUser selectByPrimaryKey(Long id);

    /**
     * 根据用户名获取用户对象
     * @param username
     * @return
     */
    SysUser selectByUsername(String username);
}
