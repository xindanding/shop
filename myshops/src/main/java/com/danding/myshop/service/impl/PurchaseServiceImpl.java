package com.danding.myshop.service.impl;

import com.danding.myshop.entity.Provider;
import com.danding.myshop.entity.Purchase;
import com.danding.myshop.mapper.PurchaseMapper;
import com.danding.myshop.service.ProviderService;
import com.danding.myshop.service.PurchaseService;
import com.danding.myshop.utils.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private ProviderService providerService;

    @Override
    public void addPurchase(Purchase purchase) {

        String providerNo = purchase.getProviderNo();
        Provider provider = providerService.getProviderByColumn("providerNo", providerNo);

        if(provider == null){
            throw new MyException("该供应商不存在");
        }
        purchase.setProviderName(provider.getProviderName());
        purchase.setStatus("1");
        purchaseMapper.addPurchase(purchase);
    }

    @Override
    public List<Purchase> getAllPurchase(Map<String, Object> params) {
        int pageSize = Integer.valueOf((String) params.get("pageSize"));
        int startSize = (Integer.valueOf((String)params.get("page")) - 1) * pageSize;
        params.put("startSize", startSize);
        params.put("pageSize", pageSize);

        String orderDateStr = (String)params.get("orderDate");
        Date orderDate = null;
        if(orderDateStr != null && orderDateStr != ""){
            try {
                orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(orderDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        params.put("orderDate", orderDate);
        return purchaseMapper.getAllPurchase(params);
    }

    @Override
    public Purchase getPurchaseById(Long id) {
        return purchaseMapper.getPurchaseById(id);
    }

    @Override
    public void updatePurchase(Purchase purchase) {
        String providerNo = purchase.getProviderNo();
        Provider provider = providerService.getProviderByColumn("providerNo", providerNo);

        if(provider == null){
            throw new MyException("该供应商不存在");
        }
        purchase.setProviderName(provider.getProviderName());
        purchaseMapper.updatePurchase(purchase);
    }

    @Override
    public void deletePurchaseById(Long id) {
        purchaseMapper.deletePurchaseById(id);
    }
}
