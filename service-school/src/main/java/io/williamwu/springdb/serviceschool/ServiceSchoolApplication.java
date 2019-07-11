package io.williamwu.springdb.serviceschool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "io.williamwu.springdb.serviceschool.mapper")
public class ServiceSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSchoolApplication.class, args);
    }

}