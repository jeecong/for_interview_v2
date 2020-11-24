package com.qiutong.work.service;


import com.qiutong.work.model.TradeDetail;

import java.util.Date;
import java.util.List;

public interface ITradeService {

    boolean trade(int transferUserId, int payeeUserId, double moneyAmount);

    double getBalance(int transferUserId);

    List<TradeDetail> getTradeFlows(Integer sourceUserId, Integer targetUserId, String date);

}
