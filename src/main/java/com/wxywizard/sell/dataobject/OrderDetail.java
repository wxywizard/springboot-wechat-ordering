package com.wxywizard.sell.dataobject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wxywizard.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: wxywizard
 */
@Entity
@Data
@DynamicUpdate
public class OrderDetail {

    /** 主键. */
    @Id
    /*@GenericGenerator(name = "system-uuid",strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")*/
    private String detailId;

    /** 订单id. */
    private String orderId;

    /** 商品id. */
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 商品价格. */
    private BigDecimal productPrice;

    /** 商品数量. */
    private Integer productQuantity;

    /** 商品小图. */
    private String productIcon;

    /** 创建时间.*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间.*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
}
