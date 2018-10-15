package com.wxywizard.sell.dto;

import lombok.Data;

/**
 * 购物车
 * @Author: wxywizard
 */
@Data
public class CartDTO {

    /** 商品id .*/
    private String productId;

    /** 数量 .*/
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
