package com.silent.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/3 21:20
 **/

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ConsumerOpenFeignOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOpenFeignOrderApplication.class, args);
    }
}
