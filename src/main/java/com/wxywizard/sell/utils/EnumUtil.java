package com.wxywizard.sell.utils;

import com.wxywizard.sell.enums.CodeEnum;

/**
 * @Author: wxywizard
 */
public class EnumUtil {

    public static <T extends CodeEnum>T getByCode(Integer code, Class<T> enumClass){
         for (T each:enumClass.getEnumConstants()){
             if (code.equals(each.getCode())){
                 return each;
             }
         }
         return null;
    }
}
