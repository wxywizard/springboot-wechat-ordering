package com.wxywizard.sell.repository;

import com.wxywizard.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    @Transactional  //测试时完全回滚，不在数据库产生数据
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("男生最爱",3);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
       // Assert.assertNotEquals(null,result);

    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}