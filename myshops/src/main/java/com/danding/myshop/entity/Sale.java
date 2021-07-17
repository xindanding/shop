package com.danding.myshop.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Sale {
    private Long id;
    private String saleNo;
    private String custNo;
    private String custName;
    private String saleName;
    private BigDecimal price;
    private Integer amount;
    private BigDecimal totalPrice;
    private String payStatus;
    private String comments;
    private String status;
    private Date saleDate;
}
