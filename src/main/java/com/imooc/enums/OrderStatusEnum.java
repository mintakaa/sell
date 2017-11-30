package com.imooc.enums;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @Author: wuguozhu.
 * @Desc:
 * @Date: 2017/11/19 15:41.
 */
@Getter
public enum OrderStatusEnum {

    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;
   private Integer code;

   private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
