package com.danding.myshop.service;


import com.danding.myshop.entity.Sale;

import java.util.List;
import java.util.Map;

public interface SalesService {
    List<Sale> getAllSale(Map<String, Object> params);

    Sale getSaleById(Long id);

    void updateSale(Sale sale);

    void deleteSaleById(Long id);

    void addSale(Sale sale);
}
