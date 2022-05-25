package com.myz.azloanmanage.controller;


import com.myz.azloanmanage.constant.ResultConstant;
import com.myz.azloanmanage.entity.SysUser;
import com.myz.azloanmanage.service.SysUserService;
import com.myz.azloanmanage.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
@Api("用户数据接口")
@CrossOrigin
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping ("/getone")
    @ApiOperation(value = "获取一个用户信息")
    public Result getone() {
        return Result.success("",sysUserService.selectByPrimaryKey(1L));
    }

    @ApiOperation(value = "获取当前登录用户的信息")
    @GetMapping("/getLoginInfo")
    public Result getLoginInfo(Principal principal) {
        if (null == principal) {
            return ResultConstant.USER_NOT_LOGGED_IN;
        }
        String username = principal.getName();
        SysUser user = sysUserService.selectByUsername(username);
        user.setPassword(null);
        return new Result(ResultConstant.USER_SELECT_SUCCESS, user);
    }


}
