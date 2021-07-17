package com.danding.myshop.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Purchase {

    private Long id;
    private String orderNo;
    private String orderName;
    private String providerNo;
    private String providerName;
    private BigDecimal price;
    private Integer amount;
    private BigDecimal totalPrice;
    private Date orderDate;
    private Character payStatus;
    private String comments;
    private String status;
}
