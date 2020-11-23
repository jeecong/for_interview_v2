package com.qiutong.work.dao.bank;

import com.qiutong.work.model.Balance;
import com.qiutong.work.model.TradeDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface TradeDao {

    /**
     * 修改金额
     *
     * @return
     */
    Boolean updateBalance(@Param("userId") Integer userId, @Param("num") Double num);

    /**
     * 插入交易记录
     *
     * @return
     */
    Boolean tradeDetail(TradeDetail tradeDetail);

    /**
     * 插入交易状态
     *
     * @return
     */
    Boolean updateTradeDetail(@Param("id") Integer id, @Param("tag") Integer tag);


    /**
     * 获取余额
     *
     * @return
     */
    Balance getBalanceForUpdate(@Param("userId") Integer userId);
}
