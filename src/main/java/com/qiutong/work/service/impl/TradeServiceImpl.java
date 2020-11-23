package com.qiutong.work.service.impl;

import com.qiutong.work.dao.bank.TradeDao;
import com.qiutong.work.model.Balance;
import com.qiutong.work.model.TradeDetail;
import com.qiutong.work.service.ITradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Slf4j
public class TradeServiceImpl implements ITradeService {

    private final TradeDao tradeDao;

    public TradeServiceImpl(TradeDao tradeDao) {
        this.tradeDao = tradeDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean trade(int transferUserId, int payeeUserId, double moneyAmount) {
        // 插入一条交易进行中的记录
        Balance transferUser = tradeDao.getBalanceForUpdate(transferUserId);
        Balance payeeUser = tradeDao.getBalanceForUpdate(payeeUserId);
        TradeDetail tradeDetail = new TradeDetail();
        tradeDetail.setMoneyAmount(moneyAmount);
        tradeDetail.setSourceUserId(transferUserId);
        tradeDetail.setTargetUserId(payeeUserId);
        tradeDetail.setSourceCardNumber(transferUser.getCardNumber());
        tradeDetail.setTargetCardNumber(payeeUser.getCardNumber());
        // 1表示交易进行中
        tradeDetail.setTag(1);

        tradeDao.tradeDetail(tradeDetail);

        // 减金额
        tradeDao.updateBalance(transferUserId, transferUser.getCurrentBalance() - moneyAmount);

        // 加金额
        tradeDao.updateBalance(payeeUserId, payeeUser.getCurrentBalance() + moneyAmount);

        // 2表示交易结束
        tradeDao.updateTradeDetail(tradeDetail.getId(), 2);

        return true;
    }
}








