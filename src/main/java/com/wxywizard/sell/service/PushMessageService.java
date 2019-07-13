package com.wxywizard.sell.service;

import com.wxywizard.sell.dto.OrderDTO;

/**
 * 推送消息
 * @author :wxywizard
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
