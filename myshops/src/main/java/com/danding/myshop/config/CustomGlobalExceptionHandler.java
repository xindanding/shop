package com.danding.myshop.config;

import com.danding.myshop.utils.CommonResult;
import com.danding.myshop.utils.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@ControllerAdvice
public class CustomGlobalExceptionHandler {

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public CommonResult myExceptionHandler(MyException e){
       log.error(e.getMessage());
       return CommonResult.error().message(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResult exceptionHandler(Exception e){
        log.error(e.getMessage(), e);
        return  CommonResult.error();
    }
}
