package com.imooc.service;

import com.imooc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import org.springframework.stereotype.Service;

/**
 * @Author: wuguozhu.
 * @Desc:
 * @Date: 2018/3/24 19:14.
 */

public interface PayService {
    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
    //RefundResponse refund
}
