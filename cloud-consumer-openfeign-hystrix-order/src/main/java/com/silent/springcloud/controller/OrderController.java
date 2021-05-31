package com.silent.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "globalHandler")
public class OrderController {

    @Resource
    private PaymentService paymentService;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
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

    @GetMapping("/getPaymentInfoOk/{id}")
    public CommonResult<String> paymentInfoOk(@PathVariable("id") Integer id) {
        return paymentService.paymentInfoOk(id);
    }

    @GetMapping("/getPaymentInfoTimeOut/{id}")
    public CommonResult<String> paymentInfoTimeOut(@PathVariable("id") Integer id) {
        return paymentService.paymentInfoTimeOut(id);
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    @GetMapping("/paymentCircuitBreaker/{id}")
    public CommonResult<String> paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.paymentCircuitBreaker(id);
    }

    public CommonResult<String> paymentInfoTimeOutHandler(Integer id) {
        CommonResult<String> stringCommonResult = new CommonResult<>(200, "异常");
        stringCommonResult.setData("特定服务提供方繁忙请稍好再试!" + id);
        return stringCommonResult;
    }

    public CommonResult<String> globalHandler() {
        CommonResult<String> stringCommonResult = new CommonResult<>(200, "异常");
        stringCommonResult.setData("全局服务提供方繁忙请稍好再试!");
        return stringCommonResult;
    }
}
