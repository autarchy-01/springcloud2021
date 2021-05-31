package com.silent.springcloud.service;

import com.silent.springcloud.entity.Payment;
import com.silent.springcloud.service.impl.PaymentServiceFallbackImpl;
import com.silent.springcloud.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @author silent
 * @version 1.0
 * @date 2021/2/22 12:10
 **/
@FeignClient(value = "cloud-payment-service",fallback = PaymentServiceFallbackImpl.class)
public interface PaymentService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @PostMapping("/payment/create")
    CommonResult<Integer> createPayment(Payment payment);

    @GetMapping("/payment/getDiscovery")
    CommonResult<String> discovery();

    @GetMapping("/payment/getPaymentInfoOk/{id}")
    CommonResult<String> paymentInfoOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/getPaymentInfoTimeOut/{id}")
    CommonResult<String> paymentInfoTimeOut(@PathVariable("id") Integer id);

    @GetMapping("/payment/paymentCircuitBreaker/{id}")
    CommonResult<String> paymentCircuitBreaker(@PathVariable("id") Integer id);
}
