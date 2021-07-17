package com.danding.myshop.service;

import com.danding.myshop.entity.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> getAllCustomer(Map<String, Object> params);

    void deleteCustomerById(Long id);

    Customer getCustomerById(Long id);

    void updateCustomer(Customer customer);

    void addCustomer(Customer customer);
}
