package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: wuguozhu.
 * @Desc:
 * @Date: 2018/3/24 19:25.
 */

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    /**
     * 公众号
     */
    private String mpAppId;

    /**
     * 公众号appSecret
     */
    private String mpAppSecret;


    /**
     * 商户号
     */
    private String mchId;


    /**
     * 商户秘钥
     */
    private String mchKey;

    /**
     * 商户证书路径
     */
    private String keyPath;

    /**
     * 微信支付异步通知地址
     */
    private String notifyUrl;



}
