package com.myz.azloanmanage.controller;

import com.myz.azloanmanage.service.SysUserService;
import com.myz.azloanmanage.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/get")
    public Result getall(){
        return sysUserService.findAll();
    }

    @PostMapping("/login")
    public Result login(@RequestBody String loginVo) {
        Result result = new Result();
        return result;
    }

}
