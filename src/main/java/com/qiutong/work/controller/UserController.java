package com.qiutong.work.controller;


import com.qiutong.work.base.Result;
import com.qiutong.work.enums.BizCodeEnum;
import com.qiutong.work.enums.ErrorCodeEnum;
import com.qiutong.work.model.User;
import com.qiutong.work.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/api/v1/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public Result<User> getUsers(@RequestParam Integer userId) {
        log.info("获取用户");
        try {
            return Result.success(userService.getUser(userId));
        } catch (Exception e) {
            return Result.fail();
        }
    }

    @PostMapping ("/login")
    public Result<User> login(HttpServletRequest request, User user) {
        if (user == null || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getUsername())) {
            return Result.fail("参数异常", ErrorCodeEnum.EMPTY_PARAMETER);
        }

        User userById = userService.getUserByName(user.getUsername(), user.getPassword());
        log.info("获取用户: {}", user.toString());
        if (userById != null) {
            return Result.success("登陆成功",BizCodeEnum.NORMAL);
        } else {
            return Result.fail("用户名或者密码错误", BizCodeEnum.LOGIN_FAIL);
        }

    }

    @PostMapping ("/register")
    public Result<User> register(HttpServletRequest request, User user) {
        if (user == null || user.getPassword() == null || user.getPassword().equals("")
                || user.getIdCard() == null || user.getIdCard().equals("") || user.getUsername() == null || user.getUsername().equals("")) {
            return Result.fail("参数异常", ErrorCodeEnum.EMPTY_PARAMETER);
        }

        try {
            int i = userService.insertUser(user);
            if (i>0){
                return Result.success("注册成功",BizCodeEnum.NORMAL);
            }

        }catch (Exception e){
            e.printStackTrace();
            return Result.fail("系统异常",ErrorCodeEnum.SYSTEM_ERROR);
        }
        return Result.fail("处理异常",ErrorCodeEnum.SYSTEM_ERROR);



    }
}
