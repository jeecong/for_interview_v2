package com.qiutong.work.model;

import lombok.Data;

import java.util.Date;

@Data
public class TradeDetail {

    private Integer id;

    private Date ctime;

    private Integer sourceUserId;

    private Integer targetUserId;

    private String sourceCardNumber;

    private String targetCardNumber;

    private Double moneyAmount;

    private Integer tag;
}
