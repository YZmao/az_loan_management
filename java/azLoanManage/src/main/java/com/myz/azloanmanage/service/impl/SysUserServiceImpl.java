package com.myz.azloanmanage.service.impl;

import com.myz.azloanmanage.entity.SysUser;
import com.myz.azloanmanage.mapper.SysUserMapper;
import com.myz.azloanmanage.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myz.azloanmanage.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author myz.azloanmanage
 * @since 2022-05-22
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public Result findAll() {
        log.info("获取用户信息");
        return Result.success("获取成功",sysUserMapper.selectList(null));
    }
}
