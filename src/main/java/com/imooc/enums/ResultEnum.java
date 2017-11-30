package com.imooc.enums;

import lombok.Getter;

/**
 * @Author: wuguozhu.
 * @Desc:
 * @Date: 2017/11/22 22:51.
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),
            ;



    private Integer code;

    private String message;

     ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }




}
