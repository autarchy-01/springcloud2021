package com.silent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/7 23:38
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(EurekaServer7001Application.class, args);
    }
}
