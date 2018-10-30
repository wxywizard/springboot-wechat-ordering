package com.wxywizard.sell.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wxywizard.sell.dataobject.OrderDetail;
import com.wxywizard.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: wxywizard
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL) 已废弃  处理为null 字段不返回
//@JsonInclude(JsonInclude.Include.NON_NULL) 单个实体类这样处理，全局可以再配置文件配置jackson
public class OrderDTO {
    /** 订单id. */
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家电话. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信openid. */
    private String buyerOpenid;

    /** 订单总额. */
    private BigDecimal orderAmount;

    /** 订单状态,默认为0新下单.*/
    private Integer orderStatus;

    /** 支付状态,默认为0未支付. */
    private Integer payStatus;

    /** 创建时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList;
}
