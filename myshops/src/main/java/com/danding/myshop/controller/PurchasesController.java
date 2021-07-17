package com.danding.myshop.controller;

import com.danding.myshop.entity.Purchase;
import com.danding.myshop.service.PurchaseService;
import com.danding.myshop.utils.CommonResult;
import com.danding.myshop.utils.ConstantsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping(value="purchase")
public class PurchasesController {

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping("getAllPurchase")
    public CommonResult getAllPurchase(HttpServletRequest request, @RequestParam Map<String, Object> params){

        List<Purchase> purchases = purchaseService.getAllPurchase(params);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put(ConstantsType.RS, purchases);
        resultMap.put(ConstantsType.TC, Long.valueOf(purchases.size()));
        return CommonResult.ok().data(resultMap);
    }

    @GetMapping("getPurchase")
    @ResponseBody
    public CommonResult getPurchase(@RequestParam("id") Long id){
        Purchase purchase = purchaseService.getPurchaseById(id);

        Map<String, Object> customerMap = new HashMap<String, Object>();
        customerMap.put("purchase", purchase);
        return CommonResult.ok().data(customerMap);
    }

    @RequestMapping("updatePurchase")
    @ResponseBody
    public CommonResult updatePurchase(@RequestBody Purchase purchase){

        purchaseService.updatePurchase(purchase);
        return CommonResult.ok();
    }


    @PostMapping("/deletePurchase")
    @ResponseBody
    public CommonResult deletePurchase(@RequestParam("id") Long id){
        purchaseService.deletePurchaseById(id);
        return CommonResult.ok();
    }

    @RequestMapping("addPurchase")
    public CommonResult addPurchase(@RequestBody Purchase purchase){

        purchaseService.addPurchase(purchase);
        return CommonResult.ok();
    }

}
