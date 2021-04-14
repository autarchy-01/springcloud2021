package com.silent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/7 23:38
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7003Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003Application.class, args);
    }
}
