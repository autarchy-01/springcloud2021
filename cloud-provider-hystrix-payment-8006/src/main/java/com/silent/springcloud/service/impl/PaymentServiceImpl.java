package com.silent.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.silent.springcloud.dao.PaymentMapper;
import com.silent.springcloud.entity.Payment;
import com.silent.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author silent
 * @version 1.0
 * @date 2021/2/3 21:47
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

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

    private static final AtomicInteger COUNT = new AtomicInteger(0);

    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "\t" + "paymentInfoOK(),id:" + id + "\t" + " \"O(∩_∩) 成功返回哈哈哈";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        logger.info("第{}请求", COUNT.getAndIncrement());
        int timeOutNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeOutNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + " id:  " + id + "\t" + "O(∩_∩)O哈哈~" + "  耗时(秒): " + timeOutNumber;
    }

    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "  8001系统繁忙或者运行报错，请稍后再试,id:  " + id + "\t" + "o(╥﹏╥)o";
    }

    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreakerFallback(Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }
}