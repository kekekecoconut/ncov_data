package com.keke;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.keke.mapper"})
@SpringBootApplication
public class NcovSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(NcovSysApplication.class, args);
    }

}
