package com.wxywizard.sell.controller;

import com.wxywizard.sell.dataobject.ProductCategory;
import com.wxywizard.sell.dataobject.ProductInfo;
import com.wxywizard.sell.service.CategoryService;
import com.wxywizard.sell.service.ProductService;
import com.wxywizard.sell.utils.ResultVOUtil;
import com.wxywizard.sell.vo.ProductInfoVO;
import com.wxywizard.sell.vo.ProductVO;
import com.wxywizard.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * @Author: wxywizard
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    //@Cacheable(cacheNames = "product",key = "123")
    //@Cacheable(cacheNames = "product",key = "#sellerId",condition = "#sellerId.length() > 3" , unless = "#result.getCode() != 0")
   // public ResultVO list(@RequestParam("sellerId") String sellerId){
    public ResultVO list(){
         //1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询类目（一次性查询）
            //传统方法
          /*  List<Integer> categoryTpeList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                categoryTpeList.add(productInfo.getCategoryType());
            }*/
          //lambda表达式
        List<Integer> categoryTpeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList =  categoryService.findByCategoryTypeIn(categoryTpeList);

        //3.数据拼装

        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }

            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
