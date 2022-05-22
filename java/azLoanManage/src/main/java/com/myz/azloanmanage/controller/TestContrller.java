package com.myz.azloanmanage.controller;


import com.myz.azloanmanage.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tset")
public class TestContrller {

    @RequestMapping("/hello")
    public Result hello(){
        return Result.success("成功","数据对接成功");
    }

}
