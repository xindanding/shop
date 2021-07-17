package com.danding.myshop.mapper;

import com.danding.myshop.entity.Purchase;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PurchaseMapper {
    void addPurchase(Purchase purchase);

    List<Purchase> getAllPurchase(@Param("params") Map<String, Object> params);

    Purchase getPurchaseById(Long id);

    void updatePurchase(Purchase purchase);

    void deletePurchaseById(Long id);
}
