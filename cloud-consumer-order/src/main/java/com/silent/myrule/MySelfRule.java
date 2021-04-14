package com.silent.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/16 15:50
 **/
@Configuration
public class MySelfRule {
    @Bean
    public IRule getRule() {
        return new RandomRule();
    }
}
