package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {


    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();


    //根据CategoryType 查询所有的数据---->
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
