package com.myz.azloanmanage.config.security;

import com.myz.azloanmanage.constant.SpringSecurityConstant;
import com.myz.azloanmanage.entity.SysUser;
import com.myz.azloanmanage.filter.JwtAuthenticationFilter;
import com.myz.azloanmanage.handler.JwtAccessDeniedHandler;
import com.myz.azloanmanage.handler.JwtAuthenticationEntryPoint;
import com.myz.azloanmanage.mapper.SysUserMapper;
import com.myz.azloanmanage.service.LoginService;
import com.myz.azloanmanage.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private JwtAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private JwtAccessDeniedHandler accessDeniedHandler;

    /**
     * ???????????????????????????
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    /**
     * ???????????????
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .mvcMatchers(SpringSecurityConstant.NONE_SECURITY_URL_PATTERNS);
    }

    /**
     * security????????????
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //??????jwt?????????csrf
        http.csrf().disable();
        //??????token???????????????session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //???????????????  ????????????????????????????????????
        http.authorizeRequests().anyRequest().authenticated();
        //????????????
        http.headers().cacheControl();
        //??????jwt????????????????????????
        http.addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        //??????????????????????????????????????????
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler).authenticationEntryPoint(authenticationEntryPoint);
    }

    /**
     * ??????WebSecurityConfigurerAdapter??????userDetailsService
     * ????????????????????????
     * @return
     */
    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            SysUser sysUser = sysUserMapper.selectByUsername(username);
            if (null != sysUser) {
                return sysUser;
            }
            throw new UsernameNotFoundException("??????????????????????????????");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter authenticationFilter() {
        return new JwtAuthenticationFilter();
    }


}
