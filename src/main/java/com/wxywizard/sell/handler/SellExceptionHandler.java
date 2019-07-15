package com.wxywizard.sell.handler;

import com.wxywizard.sell.config.ProjectUrlConfig;
import com.wxywizard.sell.exception.ResponseBankException;
import com.wxywizard.sell.exception.SellException;
import com.wxywizard.sell.exception.SellerAuthorizeException;
import com.wxywizard.sell.utils.ResultVOUtil;
import com.wxywizard.sell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: wangxy
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handlerAuthorizeException(){
          return new ModelAndView("redirect"
          .concat(projectUrlConfig.getWechatOpenAuthorize())
          .concat("/sell/wechat/qrAuthorize")
          .concat("?returnUrl=")
          .concat(projectUrlConfig.getSell())
          .concat("/sell/seller/login"));

    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){
       return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerResponseBankException(){

    }
}
