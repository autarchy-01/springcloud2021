package com.silent.springcloud.dao;


import com.silent.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author silent
 */
@Mapper
public interface PaymentMapper {

    /**
     * 新增支付信息
     *
     * @param payment 支付信息
     * @return 新增条数
     */
    int create(Payment payment);

    /**
     * 通过主键获取支付记录
     *
     * @param id 主键id
     * @return 支付记录
     */
    Payment getPaymentById(@Param("id") Long id);
}
