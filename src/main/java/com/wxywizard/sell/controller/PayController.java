package com.wxywizard.sell.controller;

import com.lly835.bestpay.model.PayResponse;
import com.wxywizard.sell.dto.OrderDTO;
import com.wxywizard.sell.enums.ResultEnum;
import com.wxywizard.sell.exception.SellException;
import com.wxywizard.sell.service.OrderService;
import com.wxywizard.sell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLDecoder;
import java.util.Map;

/**
 * @Author: wxywizard
 */
@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                                 @RequestParam("returnUrl") String returnUrl,
                                  Map<String,Object> map){

        //1.查询订单
       OrderDTO orderDTO = orderService.findOne(orderId);
       if (orderDTO == null){
           throw new SellException(ResultEnum.ORDER_NOT_EXIST);
       }
       //2.发起支付
        PayResponse payResponse = payService.create(orderDTO);
        map.put("payResponse",payResponse);
        map.put("returnUrl", URLDecoder.decode(returnUrl));
        return new ModelAndView("pay/create",map);
    }

    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyDate){
        payService.notify(notifyDate);
        //返回给微信处理结果
        return new ModelAndView("pay/success");
    }


}
