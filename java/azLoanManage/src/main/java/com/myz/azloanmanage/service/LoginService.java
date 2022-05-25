package com.myz.azloanmanage.service;

import com.myz.azloanmanage.util.Result;
import com.myz.azloanmanage.vo.LoginVo;

public interface LoginService {


    /**
     * 登录
     * @param loginVo
     * @return
     */
    Result loginVue(LoginVo loginVo);

}
