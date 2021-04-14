package com.silent.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/3 22:08
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ProviderHystrixPayment8006Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrixPayment8006Application.class, args);
    }
}
