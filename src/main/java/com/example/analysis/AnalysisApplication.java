package com.example.analysis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.analysis.controller","com.example.analysis.dao" , "com.example.analysis.service", "com.example.analysis.util"})
@MapperScan(basePackages = "com.example.analysis.dao")
@EnableAutoConfiguration
public class AnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnalysisApplication.class, args);
    }
}
