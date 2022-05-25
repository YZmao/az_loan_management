package com.myz.azloanmanage.service.impl;

import com.myz.azloanmanage.entity.SysUser;
import com.myz.azloanmanage.mapper.SysUserMapper;
import com.myz.azloanmanage.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectByPrimaryKey(Long id) {

        return sysUserMapper.selectByPrimaryKey(id);
    }
}
