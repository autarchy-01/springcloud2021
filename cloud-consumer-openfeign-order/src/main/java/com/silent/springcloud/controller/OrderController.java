package com.silent.springcloud.controller;

import com.silent.springcloud.entity.Payment;
import com.silent.springcloud.service.PaymentService;
import com.silent.springcloud.vo.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
    private PaymentService paymentService;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        logger.info("查询成功{}", id);
        return paymentService.getPaymentById(id);
    }


    @PostMapping("/create")
    public CommonResult<Integer> createPayment(Payment payment) {
        logger.info("插入成功{}", payment);
        return paymentService.createPayment(payment);
    }

    @GetMapping("/getDiscovery")
    public CommonResult<String> getDiscovery() {
        logger.info("查询服务信息成功");
        return paymentService.discovery();
    }
}
