package com.wxywizard.sell.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wxywizard
 */
@RestController
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService WxMpService;

    @GetMapping("/authorize")
    public void authorize(@RequestParam("returnUrl") String returnUrl){

        //1.配置
        //2.调用方法
    }
}
