package com.wxywizard.sell.exception;

import com.wxywizard.sell.enums.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: wxywizard
 */
public class SellException extends RuntimeException{

    private  Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
