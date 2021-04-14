package com.silent.springcloud.service;

import com.silent.springcloud.entity.Payment;
import com.silent.springcloud.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author silent
 * @version 1.0
 * @date 2021/2/22 12:10
 **/
@Component
@FeignClient(value = "cloud-payment-service")
@RequestMapping("/payment")
public interface PaymentService {

    @GetMapping("/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @PostMapping("/create")
    CommonResult<Integer> createPayment(Payment payment);

    @GetMapping("/getDiscovery")
    CommonResult<String> discovery();
}
