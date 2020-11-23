package com.qiutong.work.controller;


import com.qiutong.work.base.Result;
import com.qiutong.work.model.User;
import com.qiutong.work.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/user")

public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Result<User> getUsers(@RequestParam Integer userId) {
        log.info("获取用户");
        try {
            return Result.success(userService.getUser(userId));
        } catch (Exception e) {
            return Result.fail();
        }
    }
}
