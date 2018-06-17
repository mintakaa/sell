package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: wuguozhu.
 * @Desc:
 * @Date: 2017/11/19 16:35.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "2342343";


    @Test
    public void findByBuyerOpenid() throws Exception {

       PageRequest request = new PageRequest(0,1);

         Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID,request);
         //System.out.println(result.getTotalElements());
        Assert.assertNotEquals(0 ,result.getTotalElements());

    }

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12323");
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerPhone("13311112322");
        orderMaster.setBuyerAddress("元岗村");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(4.5));
        OrderMaster result = repository.save(orderMaster);

        Assert.assertNotNull(result);
    }


}