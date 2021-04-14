package com.silent.springcloud.controller;

import cn.hutool.core.lang.UUID;
import com.silent.springcloud.entity.Payment;
import com.silent.springcloud.service.PaymentService;
import com.silent.springcloud.vo.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/3 22:54
 **/
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @GetMapping("/consul/{id}")
    public CommonResult<Payment> getPaymentZk(@PathVariable Long id) {
        Payment payment = paymentService.selectPaymentById(id);
        logger.info("查询成功{},服务端口号是:{}", id, port);
        return new CommonResult<>(200, "查询成功,服务端口号是:" + port, payment);
    }

    @GetMapping("/getDiscovery")
    public CommonResult<DiscoveryClient> discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            logger.info("Eureka上注册的服务清单:【{}】", service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            logger.info("Eureka上注册的【{}】服务实例信息", service);
            for (ServiceInstance instance : instances) {
                logger.info("【{}】实例id【{}】,实例主机【{}】,实例端口【{}】,实例URI【{}】,实例元数据【{}】", service, instance.getInstanceId(), instance.getHost(), instance.getPort(), instance.getUri(),instance.getMetadata());
            }
        }
        return new CommonResult<>(200, "查询服务信息成功,服务端口号是:" + port+ UUID.fastUUID(), this.discoveryClient);
    }
}
