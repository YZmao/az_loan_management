package com.myz.azloanmanage.constant;

import com.myz.azloanmanage.util.Result;

public class ResultConstant {


    public static final Result USER_NOT_LOGGED_IN = new Result(403,"用户未登录");

    public static final  Result USER_SELECT_SUCCESS = new Result(200,"用户信息查询成功");

    public static final  Result LOGOUT_SUCCESS = new Result(200,"退出成功");
}
