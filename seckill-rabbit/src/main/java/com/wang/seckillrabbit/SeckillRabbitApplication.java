package com.wang.seckillrabbit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wang.seckillrabbit.mapper")
public class SeckillRabbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillRabbitApplication.class, args);
    }

}
