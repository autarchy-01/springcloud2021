package com.silent.springcloud.loadbalancer.impl;

import com.silent.springcloud.loadbalancer.LoadBalancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/16 16:14
 **/
@Component
public class MyLoadBalancer implements LoadBalancer {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    private final Logger logger = LoggerFactory.getLogger(MyLoadBalancer.class);

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        return null;
    }

    private int incrementAndGetModulo(int mod) {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            logger.info("当前服务访问次数:【{}】", current);
            next = (current + 1) % mod;
        } while (!this.atomicInteger.compareAndSet(current, next));
        return next;
    }
}
