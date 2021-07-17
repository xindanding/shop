package com.danding.myshop.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class CommonResult {

    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<String ,Object>();

     public static CommonResult ok(){
        CommonResult cr = new CommonResult();
        cr.setSuccess(true);
        cr.setCode(2000);
        cr.setMessage("成功");
        return cr;
    }

    public static CommonResult error(){
         CommonResult cr = new CommonResult();
         cr.setSuccess(false);
         cr.setCode(4000);
         cr.setMessage("失败");
         return cr;
    }

    public CommonResult success(Boolean success){
        this.setSuccess(success);
        return this;
    }
    public  CommonResult code(Integer code){
        this.setCode(code);
        return this;
    }
    public CommonResult message(String message){
        this.setMessage(message);
        return this;
    }
    public CommonResult data(Map<String, Object> result){
        this.setData(result);
        return this;
    }
}
