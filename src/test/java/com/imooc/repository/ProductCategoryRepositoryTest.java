package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
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
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }
    @Test
    //@Transactional  事务，测试时，所做的事情，做完后会给你还原，例如插入数据后在给你删掉
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("骚猪",12);
        ProductCategory result = repository.save(productCategory);

        Assert.assertNotNull(result);

    }


    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(10,2,3,4);

        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());

        System.out.println(result.toString());
    }

}