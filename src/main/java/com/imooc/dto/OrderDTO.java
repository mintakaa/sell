package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.dataobject.OrderDetail;

import com.imooc.utils.serializer.Date2LongSerializer;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: wuguozhu.
 * @Desc:
 * @Date: 2017/11/22 22:30.
 */

/**
 *
 "orderId": "1521642986165870903",
 "buyerName": "张三",
 "buyerPhone": "18868822111",
 "buyerAddress": "慕课网总部",
 "buyerOpenid": "ew3euwhd7sjw9diwkq",
 "orderAmount": 40,
 "orderStatus": 0,
 "payStatus": 0,
 "createTime": 1521351749,
 "updateTime": 1521351749,
 "orderDetailList": null
 *如果要全局设置在配置文件application.yml中添加
 * jackson:
 *     default-property-inclusion: non_null
 */

@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL) //返回json不为空,例如：orderDetailList": null
//@JsonInclude(JsonInclude.Include.NON_NULL) //与上述注解一样
public class OrderDTO {

    private String orderId;

    /**买家名字*/
    private String buyerName;

    /** 买家手机号*/
    private String buyerPhone;

    /** 买家地址*/
    private String buyerAddress;

    /** 买家微信id*/
    private String buyerOpenid;

    /** 订单总金额*/
    private BigDecimal orderAmount;

    /** 订单状态 默认为0新下单*/
    private Integer orderStatus;

    /** 支付状态 默认为0未支付*/
    private Integer payStatus;

    /** 创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
