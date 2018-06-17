package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;

/**
 * @Author: wuguozhu.
 * @Desc:
 * @Date: 2018/3/22 23:00.
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String OrderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
