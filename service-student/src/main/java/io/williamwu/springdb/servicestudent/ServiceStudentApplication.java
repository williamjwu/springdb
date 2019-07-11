package io.williamwu.springdb.servicestudent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "io.williamwu.springdb.servicestudent.mapper")
public class ServiceStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceStudentApplication.class, args);
    }

}
