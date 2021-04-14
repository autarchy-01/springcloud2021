package com.silent.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/3 21:20
 **/

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZkOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZkOrderApplication.class, args);
    }
}
