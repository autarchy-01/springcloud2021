package com.silent.springcloud.loadbalancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/16 16:09
 **/
public interface LoadBalancer {
    /**
     * 选出需要提供的服务
     *
     * @param serviceInstances 服务列表
     * @return 选出的服务
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
