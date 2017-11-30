package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategorySerivceImplTest {

    @Autowired

    private  CategorySerivceImpl categorySerivce;
    @Test
    public void findOne() throws Exception {

        ProductCategory productCategory =categorySerivce.findOne(2);
        Assert.assertEquals(new Integer(2),productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> productCategoryList = categorySerivce.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategories = categorySerivce.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0,productCategories.size());

    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory("LOL",15);
        ProductCategory result = categorySerivce.save(productCategory);
        Assert.assertNotEquals(null,result);


    }

}