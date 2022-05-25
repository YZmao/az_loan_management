package com.myz.azloanmanage.controller;


import com.myz.azloanmanage.mapper.SysUserMapper;
import com.myz.azloanmanage.service.LoginService;
import com.myz.azloanmanage.service.SysUserService;
import com.myz.azloanmanage.util.Result;
import com.myz.azloanmanage.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {


    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private LoginService loginService;

    @GetMapping ("/getone")
    public Result getone() {
        return Result.success("",sysUserService.selectByPrimaryKey(1L));
    }


    @PostMapping("/loginVue")
    public Result loginVue(@RequestBody LoginVo loginVo) {
        Result result = loginService.loginVue(loginVo);
        return result;
    }

}
