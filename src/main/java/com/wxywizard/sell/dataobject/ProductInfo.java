package com.wxywizard.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wxywizard.sell.enums.ProductStatusEnum;
import com.wxywizard.sell.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * @Author: wxywizard
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    /*@GenericGenerator(name="system-uuid",strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")*/
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 商品状态 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }

}
