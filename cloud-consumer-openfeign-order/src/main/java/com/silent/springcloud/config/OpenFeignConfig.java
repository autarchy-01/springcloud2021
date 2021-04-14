package com.silent.springcloud.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/23 10:40
 **/
@Configuration
public class OpenFeignConfig {
    @Bean
    Logger.Level openFeignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
