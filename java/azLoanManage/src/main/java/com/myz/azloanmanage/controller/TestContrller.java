package com.myz.azloanmanage.controller;


import com.myz.azloanmanage.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tset")
@Api("测试接口")
public class TestContrller {

    @GetMapping("/hello")
    @ApiOperation("连接测试接口")
    public Result hello(){
        return Result.success("成功","数据对接成功");
    }

}
