package com.danding.myshop.mapper;

import com.danding.myshop.entity.Sale;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SalesMapper {
    List<Sale> getAllSale(@Param("params") Map<String, Object> params);

    Sale getSaleById(Long id);

    void updateSale(Sale sale);

    void deleteSaleById(Long id);

    void addSale(Sale sale);
}
