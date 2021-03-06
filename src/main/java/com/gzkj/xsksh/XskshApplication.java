package com.gzkj.xsksh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableEurekaClient
//@EnableDiscoveryClient
@EnableScheduling
@EnableTransactionManagement
@MapperScan(basePackages = {"com.gzkj.xsksh.dao"})
@SpringBootApplication
public class XskshApplication {

    public static void main(String[] args) {
        SpringApplication.run(XskshApplication.class, args);
    }


}
