package com.myz.azloanmanage;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@MapperScan("com.myz.azloanmanage.mapper")
public class AzLoanManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AzLoanManageApplication.class, args);
    }

}
