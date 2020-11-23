package com.qiutong.work.controller;

import com.qiutong.work.base.Result;
import com.qiutong.work.enums.BizCodeEnum;
import com.qiutong.work.enums.ErrorCodeEnum;
import com.qiutong.work.service.ITradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/getUserBalance")
    public Result<Double> getBalance(HttpServletRequest request, @RequestParam Integer userId) {
        log.info("查询");
        try {
            Double balance = tradeService.getBalance(userId);
            return Result.success(balance,"成功",BizCodeEnum.NORMAL);
        } catch (Exception e) {
            return Result.fail("系统异常", ErrorCodeEnum.SYSTEM_ERROR);
        }
    }
}
