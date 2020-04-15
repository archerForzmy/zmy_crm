package com.zzy.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zzy.crm.mapper")
public class ZzyCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzyCrmApplication.class, args);
    }

}
