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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getSourceUserId() {
        return sourceUserId;
    }

    public void setSourceUserId(Integer sourceUserId) {
        this.sourceUserId = sourceUserId;
    }

    public Integer getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(Integer targetUserId) {
        this.targetUserId = targetUserId;
    }

    public String getSourceCardNumber() {
        return sourceCardNumber;
    }

    public void setSourceCardNumber(String sourceCardNumber) {
        this.sourceCardNumber = sourceCardNumber;
    }

    public String getTargetCardNumber() {
        return targetCardNumber;
    }

    public void setTargetCardNumber(String targetCardNumber) {
        this.targetCardNumber = targetCardNumber;
    }

    public Double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(Double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }
}
