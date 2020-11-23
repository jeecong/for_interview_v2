package com.qiutong.work.service;


import com.qiutong.work.model.Balance;

import java.util.Date;
import java.util.List;

public interface ITradeService {

    boolean trade(int transferUserId, int payeeUserId, double moneyAmount);

    double getBalance(int transferUserId);

    List<Balance> getTradeFlows(Integer sourceUserId, Integer targetUserId, Date date);

}
