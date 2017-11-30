package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * @Author: wuguozhu.
 * @Desc:
 * @Date: 2017/11/22 22:50.
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }
}
