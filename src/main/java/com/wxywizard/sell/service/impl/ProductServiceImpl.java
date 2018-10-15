package com.wxywizard.sell.service.impl;

import com.wxywizard.sell.dataobject.ProductInfo;
import com.wxywizard.sell.dto.CartDTO;
import com.wxywizard.sell.enums.ProductStatusEnum;
import com.wxywizard.sell.enums.ResultEnum;
import com.wxywizard.sell.exception.SellException;
import com.wxywizard.sell.repository.ProductInfoRepository;
import com.wxywizard.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @Author: wxywizard
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(productId);
        Example<ProductInfo> example = Example.of(productInfo);
        Optional<ProductInfo> optional = repository.findOne(example);
        return optional.get();
    }

    @Override
    public List<ProductInfo> findUpAll() {

        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable)
    {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {

        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {


    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList){
            ProductInfo productInfoObj = new ProductInfo();
            productInfoObj.setProductId(cartDTO.getProductId());
            Example example = Example.of(productInfoObj);
            Optional<ProductInfo> optional = repository.findOne(example);
            ProductInfo productInfo =  optional.get();
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfoObj.setProductStock(result);
            repository.save(productInfoObj);
        }
    }
}
