package com.danding.myshop.entity;

import lombok.Data;

@Data
public class Customer {

    private Long id;
    private String custNo;
    private String custName;
    private String address;
    private String cellPhone;
    private String phone;
    private String status;


}
