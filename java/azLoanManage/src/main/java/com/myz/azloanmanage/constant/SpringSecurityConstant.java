package com.myz.azloanmanage.constant;


public class SpringSecurityConstant {

    /**
     * 放开权限校验的接口
     */
    public static final String[] NONE_SECURITY_URL_PATTERNS = {

            //前端的
            "/favicon.ico",

            //swagger相关的
            "/doc.html",
            "/webjars/**",
            "/swagger-resources/**",
            "/v2/api-docs",
            "/v2/api-docs-ext",
            "/configuration/ui",
            "/configuration/security",

            //后端的
            "/user/**",
            "/user/login",
            "/user/logout",
            "/oauth/**",
            "/user/get",

            //微信小程序资源
            "/user/wxlogin",
            //发送手机验证码
            "/user/sendSms",
            //druid的
            "/druid/**",

            //获取验证码
            "/captcha/**",
            "/getCaptchaOpen",
    };
}