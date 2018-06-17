package com.imooc.converter;

import com.imooc.dataobject.OrderMaster;
import com.imooc.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: wuguozhu.
 * @Desc:
 * @Date: 2018/3/17 16:43.
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO converter(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> converter(List<OrderMaster> orderMasterList){
        return orderMasterList
                .stream().map(e ->
                        converter(e)
                ).collect(Collectors.toList());
    }
}
