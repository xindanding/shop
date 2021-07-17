package com.danding.myshop.service;

import com.danding.myshop.entity.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProviderService {
    void addProvider(Provider provider);

    List<Provider> getAllProvider(Map<String, Object> params);

    Provider getProviderById(Long id);

    void updateProvider(Provider provider);

    void deleteProviderById(Long id);

    Provider getProviderByColumn(@Param("columnN") String columnN, @Param("columnV") String columnV);
}
