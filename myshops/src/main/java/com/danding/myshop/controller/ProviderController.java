package com.danding.myshop.controller;

import com.danding.myshop.entity.Provider;
import com.danding.myshop.service.ProviderService;
import com.danding.myshop.utils.CommonResult;
import com.danding.myshop.utils.ConstantsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @RequestMapping("/getAllProvider")
    @ResponseBody
    public CommonResult getAllProvider(HttpServletRequest request, @RequestParam Map<String, Object> params){

        List<Provider> providers = providerService.getAllProvider(params);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put(ConstantsType.RS, providers);
        resultMap.put(ConstantsType.TC, Long.valueOf(providers.size()));
        return CommonResult.ok().data(resultMap);
    }


    @RequestMapping("/addProvider")
    @ResponseBody
    public CommonResult addProvider(@RequestBody Provider provider){

        providerService.addProvider(provider);
        return CommonResult.ok();
    }

    @GetMapping("getProvider")
    @ResponseBody
    public CommonResult getProvider(@RequestParam("id") Long id){
        Provider provider = providerService.getProviderById(id);

        Map<String, Object> providerMap = new HashMap<String, Object>();
        providerMap.put("provider", provider);
        return CommonResult.ok().data(providerMap);
    }

    @RequestMapping("updateProvider")
    @ResponseBody
    public CommonResult updateProvider(Provider provider){

        providerService.updateProvider(provider);
        return CommonResult.ok();
    }

    @PostMapping("/deleteProvider")
    @ResponseBody
    public CommonResult deleteProvider(@RequestParam("id") Long id){
        providerService.deleteProviderById(id);
        return CommonResult.ok();
    }
}
