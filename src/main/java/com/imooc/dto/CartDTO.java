package com.imooc.dto;

import lombok.Data;

/**
 * @Author: wuguozhu.
 * @Desc:
 * @Date: 2017/12/9 13:47.
 */
@Data
public class CartDTO {
    private String producetId;

    private Integer productQuantity;

    public CartDTO(String producetId, Integer productQuantity) {
        this.producetId = producetId;
        this.productQuantity = productQuantity;
    }
}
