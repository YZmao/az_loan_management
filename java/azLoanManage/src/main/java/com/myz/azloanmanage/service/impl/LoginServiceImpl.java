package com.myz.azloanmanage.service.impl;

import com.myz.azloanmanage.service.LoginService;
import com.myz.azloanmanage.util.Result;
import com.myz.azloanmanage.util.TokenUtil;
import com.myz.azloanmanage.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    /**
     * 登录接口
     * @param loginVo
     * @return
     */

    @Override
    public Result loginVue(LoginVo loginVo){

        log.info("开始登录");
        UserDetails userDetails =  userDetailsService.loadUserByUsername(loginVo.getUsername());
        log.info("判断用户是否存在，密码是否正确");
        if (userDetails == null || !passwordEncoder.matches(loginVo.getPassword(),userDetails.getPassword())){
            return Result.fail(200,"账号或密码错误，请重新输入！");
        }
        if (!userDetails.isEnabled()){
            return Result.fail(200,"账号已被禁用，请联系管理员");
        }
        log.info("登录成功，在security对象中存入登录者信息");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        log.info("根据登录信息获取token");
        //需要借助
        String token = tokenUtil.generateToken(userDetails);
        Map<String, String> map = new HashMap<>(2);
        map.put("tokenHead", tokenHead);
        map.put("token", token);
        return Result.success("登录成功！",map);
    }
}
