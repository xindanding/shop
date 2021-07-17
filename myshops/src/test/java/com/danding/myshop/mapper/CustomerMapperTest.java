package com.danding.myshop.mapper;

import com.danding.myshop.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class CustomerMapperTest {

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void test(){
        Customer c = customerMapper.getCustomerByColumn("custNo", "C0051");
        log.info(c.getCustName());
    }
}