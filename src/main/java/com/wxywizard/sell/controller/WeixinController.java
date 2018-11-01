package com.wxywizard.sell.controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wxywizard
 */
@RestController
@Slf4j
@RequestMapping("/weixin")
public class WeixinController {

    /**
     * 测试微信授权
     */
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){

        log.info("进入auth方法。。。");
        log.info("code={}",code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx557a6ea91652f1d1&secret=338677634e7f31c11add1cc3314b2a6c&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url,String.class);
        log.info("response={}",response);
        Gson gson = new Gson();
        Map<String,String> map = new HashMap<>();
        try {
            map = gson.fromJson(response,new TypeToken<Map<String,String>>(){}.getType());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        String openid = map.get("openid");
        String accessToken = map.get("access_token");
        String url2 = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openid + "&lang=zh_CN";
        RestTemplate restTemplate2 = new RestTemplate();
        String response2 = restTemplate2.getForObject(url2,String.class);
        try {
            log.info("response2={}", new String(response2.getBytes("iso-8859-1"),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
