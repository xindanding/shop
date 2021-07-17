package com.danding.myshop.service.impl;

import com.danding.myshop.entity.Customer;
import com.danding.myshop.mapper.CustomerMapper;
import com.danding.myshop.service.CustomerService;
import com.danding.myshop.utils.ConstantsType;
import com.danding.myshop.utils.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> getAllCustomer(Map<String, Object> params) {
        int page = ConstantsType.PAGE;
        int pageSize = ConstantsType.PAGE_SIZE;
        if(params.get("page") != null){
            page = Integer.valueOf((String)params.get("page"));
        }
        if(params.get("pageSize") != null){
            pageSize =  Integer.valueOf((String)params.get("pageSize"));
        }
        List<Customer> custs = customerMapper.findAllCustomer(params, (page-1)*pageSize, pageSize);
        return custs;
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerMapper.deleteCustomerById(id);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerMapper.getCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Long id = customer.getId();
        Customer cust = customerMapper.getCustomerByColumnExcludeId("custNo", customer.getCustNo(), id);
//        Customer cust = customerMapper.getCustomerByColumn("custNo", customer.getCustNo());
        if(cust != null){
            throw new MyException("客户编号已经存在");
        }
        customerMapper.updateCustomer(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        Customer cust = customerMapper.getCustomerByColumn("custNo", customer.getCustNo());
        if(cust != null){
            throw new MyException("客户编号已经存在");
        }

        customerMapper.addCustomer(customer);
    }

}
