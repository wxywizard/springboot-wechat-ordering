package com.wxywizard.sell.service.impl;

import com.wxywizard.sell.dto.OrderDTO;
import com.wxywizard.sell.service.OrderService;
import com.wxywizard.sell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("1540803480912988024");
        payService.create(orderDTO);

    }

    @Test
    public void refund(){
        OrderDTO orderDTO = orderService.findOne("1541572997465924948");
        payService.refund(orderDTO);
    }
}