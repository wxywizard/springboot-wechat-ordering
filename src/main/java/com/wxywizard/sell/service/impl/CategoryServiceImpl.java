package com.wxywizard.sell.service.impl;

import com.wxywizard.sell.dataobject.ProductCategory;
import com.wxywizard.sell.repository.ProductCategoryRepository;
import com.wxywizard.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author: wangxy
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(categoryId);
        Example<ProductCategory> example = Example.of(productCategory);
        Optional<ProductCategory> optional =  repository.findOne(example);
        return optional.get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
