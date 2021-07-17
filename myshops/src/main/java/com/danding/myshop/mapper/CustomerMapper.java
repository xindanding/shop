package com.danding.myshop.mapper;

import com.danding.myshop.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//使用@MapperScan进行全局配置
//@Mapper
@Repository
public interface CustomerMapper {

    List<Customer> findAllCustomer(@Param(value = "params") Map<String, Object> params,
                                   @Param(value="startSize") int startSize,
                                   @Param(value="pageSize") int pageSize);

    void deleteCustomerById(@Param(value="id") Long id);

    Customer getCustomerById(Long id);

    void updateCustomer(Customer customer);

    Customer getCustomerByColumn(@Param("columnN") String columnN, @Param("columnV") String columnV);

    void addCustomer(Customer customer);

    Customer getCustomerByColumnExcludeId(@Param("columnN")String columnN, @Param("columnV") String custNo1,
                                          @Param("id") Long id);
}
