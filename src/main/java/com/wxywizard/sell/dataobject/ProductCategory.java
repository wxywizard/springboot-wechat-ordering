package com.wxywizard.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

/**
 * @Author: wangxy
 */
@Table(name = "product_category")
@Entity
@Data
@DynamicUpdate
public class ProductCategory {

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    /**类目id.*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /**类目名字.*/
    private String categoryName;

    /**类目编号.*/
    private Integer categoryType;


}
