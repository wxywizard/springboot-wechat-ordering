package com.wxywizard.sell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/*// ComponentScan注解用于加载指定目录文件下的所有的注解对象
@ComponentScan(value = {"com.wxywizard"})
@Configuration*/
@SpringBootApplication
@EnableCaching
public class SellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellApplication.class, args);
    }
}
