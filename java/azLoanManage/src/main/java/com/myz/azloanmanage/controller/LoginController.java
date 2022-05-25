package com.myz.azloanmanage.controller;


import com.myz.azloanmanage.constant.ResultConstant;
import com.myz.azloanmanage.entity.SysUser;
import com.myz.azloanmanage.service.LoginService;
import com.myz.azloanmanage.service.SysUserService;
import com.myz.azloanmanage.util.Result;
import com.myz.azloanmanage.util.SecurityUtil;
import com.myz.azloanmanage.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
@RequestMapping("/user")
@Api("用户登录接口")
@CrossOrigin
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
        System.out.println(result.getData());
        return result;
    }

    @GetMapping("/logout")
    @ApiOperation(value = "退出", httpMethod = "GET")
    public Result logout(HttpServletRequest request, HttpServletResponse response) {
        Long userId = SecurityUtil.getUserId();
        //删除菜单信息
        //redisUtil.delKey("menu_" + userId);
        //清除spring security用户认证信息
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return ResultConstant.LOGOUT_SUCCESS;
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
