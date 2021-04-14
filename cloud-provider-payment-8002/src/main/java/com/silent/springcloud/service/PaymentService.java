package com.silent.springcloud.service;

import com.silent.springcloud.entity.Payment;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/3 21:47
 **/
public interface PaymentService {
    /**
     * 创建支付记录
     *
     * @param payment 支付记录
     * @return 插入条数
     */
    int create(Payment payment);

    /**
     * 通过id查找支付记录
     *
     * @param id 支付id
     * @return 支付记录
     */
    Payment selectPaymentById(Long id);

}
