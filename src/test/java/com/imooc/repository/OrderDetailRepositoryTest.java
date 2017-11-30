package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: wuguozhu.
 * @Desc:
 * @Date: 2017/11/19 17:23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {


    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
       OrderDetail orderDetail = new OrderDetail();

       orderDetail.setDetailId("2332234324");
       orderDetail.setOrderId("231133213");
       orderDetail.setProductIcon("http://ddddd.com");
       orderDetail.setProductId("67834782");
       orderDetail.setProductName("老虎粥");
       orderDetail.setProductPrice(new BigDecimal(5.5));
       orderDetail.setProductQuantity(4);

       OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrderId("231133213");
        Assert.assertNotEquals(0,orderDetailList.size());
    }

}