package com.myz.azloanmanage.controller;


import com.myz.azloanmanage.mapper.SysUserMapper;
import com.myz.azloanmanage.service.LoginService;
import com.myz.azloanmanage.service.SysUserService;
import com.myz.azloanmanage.util.Result;
import com.myz.azloanmanage.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api("用户登录接口")
public class LoginController {


    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private LoginService loginService;

    @GetMapping ("/getone")
    @ApiOperation(value = "获取一个用户信息")
    public Result getone() {
        return Result.success("",sysUserService.selectByPrimaryKey(1L));
    }


    @PostMapping("/loginVue")
    @ApiOperation(value = "登录接口")
    public Result loginVue(@RequestBody LoginVo loginVo) {
        Result result = loginService.loginVue(loginVo);
        return result;
    }

}
