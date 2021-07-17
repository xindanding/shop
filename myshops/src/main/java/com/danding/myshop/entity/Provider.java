package com.danding.myshop.entity;

import lombok.Data;

@Data
public class Provider {

    private Long id;
    private String providerNo;
    private String providerName;
    private String address;
    private String cellPhone;
    private String phone;
}
