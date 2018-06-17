package com.imooc.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: wuguozhu.
 * @Desc:
 * @Date: 2018/3/24 23:19.
 */
@Component
public class WechatMpConfig {


    @Autowired
    private WechatAccountConfig accountConfig;


    @Bean
    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();

        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());

        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpInMemoryConfigStorage WxMpConfigStorage = new WxMpInMemoryConfigStorage();
        WxMpConfigStorage.setAppId(accountConfig.getMpAppId());
        WxMpConfigStorage.setSecret(accountConfig.getMpAppSecret());
        return WxMpConfigStorage;
    }
}
