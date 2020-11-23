package com.qiutong.work.controller;

import com.qiutong.work.base.Result;
import com.qiutong.work.service.ITradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/trade")

public class TradeController {

    private final ITradeService tradeService;

    public TradeController(ITradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping
    public Result<Boolean> trade(@RequestParam Integer transferUserId, @RequestParam Integer payeeUserId, @RequestParam Double moneyAmount) {
        log.info("交易开始");
        try {
            return Result.success(tradeService.trade(transferUserId, payeeUserId, moneyAmount));
        } catch (Exception e) {
            return Result.fail();
        }
    }
}
