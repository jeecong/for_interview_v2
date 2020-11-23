package com.qiutong.work.service;


public interface ITradeService {

    boolean trade(int transferUserId, int payeeUserId, double moneyAmount);

}
