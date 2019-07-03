package io.williamwu.springdb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@MapperScan(basePackages = "io.williamwu.springdb.mapper")
public class SpringdbApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringdbApplication.class, args);
    }
}