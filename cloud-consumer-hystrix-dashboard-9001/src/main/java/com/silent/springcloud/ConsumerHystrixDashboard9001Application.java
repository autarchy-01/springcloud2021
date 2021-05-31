package com.silent.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author silent
 * @version 1.0
 * @date 2021/5/30 9:28
 **/
@SpringBootApplication
@EnableHystrixDashboard
@EnableEurekaClient
@EnableTurbine
public class ConsumerHystrixDashboard9001Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashboard9001Application.class, args);
    }
}
