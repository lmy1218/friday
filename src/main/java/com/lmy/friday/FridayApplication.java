package com.lmy.friday;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan("com.lmy.friday.mapper")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FridayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FridayApplication.class, args);
    }

}
