package com.wxywizard.sell.exception;

import com.wxywizard.sell.enums.ResultEnum;
import lombok.Getter;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: wxywizard
 */
@Getter
public class SellException extends RuntimeException{

    private  Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
