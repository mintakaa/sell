package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String produceId);


    /**
     * 查询在架商品列表
     * @return
     * */
    List<ProductInfo> findUpAll();


    /**
     * 查询所有商品，分页查询
     * */
    Page<ProductInfo> findAll(Pageable pageable);



    ProductInfo save(ProductInfo productInfo);

    //加库存

    //减库存
}
