package com.silent.springcloud.controller;

import com.silent.springcloud.entity.Payment;
import com.silent.springcloud.service.PaymentService;
import com.silent.springcloud.vo.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @GetMapping("/zk/{id}")
    public CommonResult<Payment> getPaymentZk(@PathVariable Long id) {
        Payment payment = paymentService.selectPaymentById(id);
        logger.info("查询成功{},服务端口号是:{}", id, port);
        return new CommonResult<>(200, "查询成功,服务端口号是:" + port, payment);
    }
}
