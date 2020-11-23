package com.qiutong.work.model;

import lombok.Data;

import java.util.Date;

@Data
public class Balance {

    private Integer id;

    private Integer userId;

    private String cardNumber;

    private Double currentBalance;
}
