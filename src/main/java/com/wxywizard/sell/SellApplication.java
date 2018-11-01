package com.wxywizard.sell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*// ComponentScan注解用于加载指定目录文件下的所有的注解对象
@ComponentScan(value = {"com.wxywizard"})
@Configuration*/
@SpringBootApplication
public class SellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellApplication.class, args);
    }
}
