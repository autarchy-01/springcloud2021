package com.silent.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/3 22:08
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ProviderHystrixPayment8006Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrixPayment8006Application.class, args);
    }

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> hystrixMetricsStreamServletServletRegistrationBean = new ServletRegistrationBean<>(hystrixMetricsStreamServlet);
        hystrixMetricsStreamServletServletRegistrationBean.setLoadOnStartup(1);
        hystrixMetricsStreamServletServletRegistrationBean.addUrlMappings("/hystrix.stream");
        hystrixMetricsStreamServletServletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return hystrixMetricsStreamServletServletRegistrationBean;
    }
}
