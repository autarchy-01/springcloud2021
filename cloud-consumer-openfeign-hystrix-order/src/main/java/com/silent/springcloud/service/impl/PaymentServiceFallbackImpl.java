package com.silent.springcloud.service.impl;

import com.silent.springcloud.entity.Payment;
import com.silent.springcloud.service.PaymentService;
import com.silent.springcloud.vo.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @author silent
 * @version 1.0
 * @date 2021/5/26 21:00
 **/
@Component
public class PaymentServiceFallbackImpl implements PaymentService {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return null;
    }

    @Override
    public CommonResult<Integer> createPayment(Payment payment) {
        return null;
    }

    @Override
    public CommonResult<String> discovery() {
        return null;
    }

    @Override
    public CommonResult<String> paymentInfoOk(Integer id) {
        return null;
    }

    @Override
    public CommonResult<String> paymentInfoTimeOut(Integer id) {
        CommonResult<String> stringCommonResult = new CommonResult<>(200, "异常");
        stringCommonResult.setData("FeignClient服务降级");
        return stringCommonResult;
    }

    @Override
    public CommonResult<String> paymentCircuitBreaker(Integer id) {
        CommonResult<String> stringCommonResult = new CommonResult<>(200, "异常");
        stringCommonResult.setData("FeignClient服务降级");
        return stringCommonResult;
    }
}
