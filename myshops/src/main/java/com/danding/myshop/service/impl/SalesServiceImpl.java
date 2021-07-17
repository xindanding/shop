package com.danding.myshop.service.impl;

import com.danding.myshop.entity.Customer;
import com.danding.myshop.entity.Sale;
import com.danding.myshop.mapper.CustomerMapper;
import com.danding.myshop.mapper.SalesMapper;
import com.danding.myshop.service.SalesService;
import com.danding.myshop.utils.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesMapper salesMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Sale> getAllSale(Map<String, Object> params) {
        int pageSize = Integer.valueOf((String) params.get("pageSize"));
        int startSize = (Integer.valueOf((String)params.get("page")) - 1) * pageSize;
        params.put("startSize", startSize);
        params.put("pageSize", pageSize);
        String saleDateStr = (String)params.get("saleDate");
        Date saleDate = null;
        if(saleDateStr != null && saleDateStr != ""){
            try {
                saleDate = new SimpleDateFormat("yyyy-MM-dd").parse(saleDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        params.put("saleDate", saleDate);
        return salesMapper.getAllSale(params);
    }

    @Override
    public Sale getSaleById(Long id) {
        return salesMapper.getSaleById(id);
    }

    @Override
    public void updateSale(Sale sale) {
        Customer cust = customerMapper.getCustomerByColumn("custNo", sale.getCustNo());
        if(cust == null){
            throw new MyException("该客户不存在");
        }

        sale.setCustName(cust.getCustName());
        salesMapper.updateSale(sale);
    }

    @Override
    public void deleteSaleById(Long id) {
        salesMapper.deleteSaleById(id);
    }

    @Override
    public void addSale(Sale sale) {
        Customer cust = customerMapper.getCustomerByColumn("custNo", sale.getCustNo());
        if(cust == null){
            throw new MyException("该客户不存在");
        }

        sale.setCustName(cust.getCustName());
        sale.setStatus("0");
        salesMapper.addSale(sale);
    }
}
