package com.silent.springcloud;

import com.silent.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/3 21:20
 **/

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(value = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class ConsumerOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplication.class, args);
    }
}
