package com.myz.azloanmanage.service;

import com.myz.azloanmanage.entity.SysUser;
import com.myz.azloanmanage.vo.UserMenuVo;

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

    /**
     * 根据用户id获取用户菜单列表
     * @param id
     * @return
     */
    UserMenuVo  selectUserMenulistByUsername(Long id);
}
