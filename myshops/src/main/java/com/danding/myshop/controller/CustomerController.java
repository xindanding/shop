package com.danding.myshop.controller;

import com.danding.myshop.entity.Customer;
import com.danding.myshop.service.CustomerService;
import com.danding.myshop.utils.CommonResult;
import com.danding.myshop.utils.ConstantsType;
import com.danding.myshop.utils.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("cust")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //允许跨域  在CustomerWebMvcConfigurer中全局配置
//    @CrossOrigin
    @RequestMapping("/getAllCustomer")
    @ResponseBody
    public CommonResult getAllCustomer(HttpServletRequest request, @RequestParam Map<String, Object> params){

        List<Customer> customers = customerService.getAllCustomer(params);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put(ConstantsType.RS, customers);
        resultMap.put(ConstantsType.TC, Long.valueOf(customers.size()));
        return CommonResult.ok().data(resultMap);
    }

    @PostMapping("/deleteCustomer")
    @ResponseBody
    public CommonResult deleteCustomer(@RequestParam("id") Long id){
        customerService.deleteCustomerById(id);
        return CommonResult.ok();
    }

    @GetMapping("getCustomer")
    @ResponseBody
    public CommonResult getCustomer(@RequestParam("id") Long id){
        Customer customer = customerService.getCustomerById(id);

        Map<String, Object> customerMap = new HashMap<String, Object>();
        customerMap.put("cust", customer);
        return CommonResult.ok().data(customerMap);
    }

    @RequestMapping("updateCustomer")
    @ResponseBody
    public CommonResult updateCustomer(Customer customer){

        customerService.updateCustomer(customer);
        return CommonResult.ok();
    }

    @RequestMapping("addCustomer")
    @ResponseBody
    public CommonResult addCustomer(Customer customer){
        customerService.addCustomer(customer);
        return CommonResult.ok();
    }
}
