package com.myz.azloanmanage.service;

import com.myz.azloanmanage.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myz.azloanmanage.util.Result;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author myz.azloanmanage
 * @since 2022-05-22
 */
public interface SysUserService extends IService<SysUser> {

    public Result findAll();

}
