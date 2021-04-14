package com.silent.springcloud.controller;

import com.silent.springcloud.entity.Payment;
import com.silent.springcloud.vo.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/4 14:09
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment";

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);



    @PostMapping("/create")
    public CommonResult<Integer> createPayment(Payment payment) {
        logger.info("插入成功{}", payment);
        return restTemplate.postForObject(PAYMENT_URL + "/create/", payment, CommonResult.class);
    }

    @GetMapping("/getDiscovery")
    public CommonResult<Payment> getDiscovery() {
        logger.info("查询服务信息成功");
        return restTemplate.getForObject(PAYMENT_URL + "/getDiscovery", CommonResult.class);
    }
}
