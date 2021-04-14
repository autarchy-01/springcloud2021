package com.silent.springcloud.service.impl;

import com.silent.springcloud.dao.PaymentMapper;
import com.silent.springcloud.entity.Payment;
import com.silent.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/3 21:47
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    /**
     * 创建支付记录
     *
     * @param payment 支付记录
     * @return 插入条数
     */
    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    /**
     * 通过id查找支付记录
     *
     * @param id 支付id
     * @return 支付记录
     */
    @Override
    public Payment selectPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
