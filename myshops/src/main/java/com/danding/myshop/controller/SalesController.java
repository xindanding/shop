package com.danding.myshop.controller;

import com.danding.myshop.entity.Sale;
import com.danding.myshop.service.SalesService;
import com.danding.myshop.utils.CommonResult;
import com.danding.myshop.utils.ConstantsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sale")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @RequestMapping("getAllSale")
    public CommonResult getAllSale(@RequestParam Map<String, Object> params){

        List<Sale> sales = salesService.getAllSale(params);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put(ConstantsType.RS, sales);
        resultMap.put(ConstantsType.TC, Long.valueOf(sales.size()));
        return CommonResult.ok().data(resultMap);
    }

    @PostMapping("/deleteSale")
    @ResponseBody
    public CommonResult deleteSale(@RequestParam("id") Long id){
        salesService.deleteSaleById(id);
        return CommonResult.ok();
    }

    @GetMapping("getSale")
    @ResponseBody
    public CommonResult getSale(@RequestParam("id") Long id){
        Sale sale = salesService.getSaleById(id);

        Map<String, Object> customerMap = new HashMap<String, Object>();
        customerMap.put("sale", sale);
        return CommonResult.ok().data(customerMap);
    }

    @RequestMapping("updateSale")
    @ResponseBody
    public CommonResult updateSale(@RequestBody Sale sale){

        salesService.updateSale(sale);
        return CommonResult.ok();
    }

    @RequestMapping("/addSale")
    @ResponseBody
    public CommonResult addSale(@RequestBody Sale sale){

        salesService.addSale(sale);
        return CommonResult.ok();
    }
}
