package com.qiutong.work.service.impl;

import com.qiutong.work.dao.bank.TradeDao;
import com.qiutong.work.dao.bank.UserDao;
import com.qiutong.work.model.Balance;
import com.qiutong.work.model.TradeDetail;
import com.qiutong.work.model.User;
import com.qiutong.work.service.ITradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Slf4j
public class TradeServiceImpl implements ITradeService {

    private final UserDao userDao;

    private final TradeDao tradeDao;

    public TradeServiceImpl(UserDao userDao, TradeDao tradeDao) {
        this.userDao = userDao;
        this.tradeDao = tradeDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean trade(int transferUserId, int payeeUserId, double moneyAmount) {
        // 插入一条交易进行中的记录
        User transferUser = userDao.getUserById(transferUserId);
        User payeeUser = userDao.getUserById(transferUserId);
        TradeDetail tradeDetail = new TradeDetail();
        tradeDetail.setMoneyAmount(moneyAmount);
        tradeDetail.setSourceUserId(transferUserId);
        tradeDetail.setTargetUserId(payeeUserId);
        // 1表示交易进行中
        tradeDetail.setTag(1);
        tradeDao.tradeDetail(tradeDetail);

        // 减金额
        tradeDao.updateBalance(transferUserId, transferUser);

        // 加金额
        tradeDao.updateBalance(payeeUserId, 1.0);



        return true;
    }

    @Override
    public double getBalance(int userId) {
        Balance balanceForUpdate = tradeDao.getBalanceForUpdate(userId);
        return balanceForUpdate.getCurrentBalance();
    }
}








