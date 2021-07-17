package com.danding.myshop.service;

import com.danding.myshop.entity.Purchase;

import java.util.List;
import java.util.Map;

public interface PurchaseService {
    void addPurchase(Purchase purchase);

    List<Purchase> getAllPurchase(Map<String, Object> params);

    Purchase getPurchaseById(Long id);

    void updatePurchase(Purchase purchase);

    void deletePurchaseById(Long id);
}
