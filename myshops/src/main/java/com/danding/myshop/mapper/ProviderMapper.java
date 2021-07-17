package com.danding.myshop.mapper;

import com.danding.myshop.entity.Provider;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProviderMapper {

    void addProvider(Provider provider);

    Provider findProviderByColumn(@Param("columnN") String columnName, @Param("columnV")String columnValue);

    List<Provider> getAllProvider(@Param(value = "params") Map<String, Object> params,
                                  @Param(value="startSize") int startSize,
                                  @Param(value="pageSize") int pageSize);

    Provider getProviderById(Long id);

    void updateProvier(Provider provider);

    void deleteProviderById(Long id);

    Provider getProviderByColumn(@Param("columnN") String columnN, @Param("columnV")String columnV);
}
