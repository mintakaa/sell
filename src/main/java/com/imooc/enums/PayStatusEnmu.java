package com.imooc.enums;

import lombok.Getter;

/**
 * @Author: wuguozhu.
 * @Desc:
 * @Date: 2017/11/19 15:48.
 */

@Getter
public enum PayStatusEnmu {

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnmu(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
