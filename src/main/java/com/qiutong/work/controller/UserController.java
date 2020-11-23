package com.qiutong.work.controller;


import com.qiutong.work.base.Result;
import com.qiutong.work.enums.BizCodeEnum;
import com.qiutong.work.enums.ErrorCodeEnum;
import com.qiutong.work.module.User;
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

    @GetMapping("/getUser")
    public Result<User> getUsers(@RequestParam Integer userId) {
        log.info("获取用户");
        try {
            return Result.success(userService.getUser(userId));
        } catch (Exception e) {
            return Result.fail();
        }
    }

    @GetMapping("/login")
    public Result<User> login(HttpServletRequest request, User user) {
        if (user == null || user.getUserId() == null) {
            return Result.fail("参数异常", ErrorCodeEnum.EMPTY_PARAMETER);
        }
        Integer userId = user.getUserId();

        User userById = userService.getUserById(userId);
        log.info("获取用户: {}", user.toString());
        if (userById.getPassword() == user.getPassword()) {
            return Result.success("登陆成功",BizCodeEnum.NORMAL);
        } else {
            return Result.fail("用户名或者密码错误", BizCodeEnum.LOGIN_FAIL);
        }

    }

    @GetMapping("/register")
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
            return Result.fail("系统异常",ErrorCodeEnum.SYSTEM_ERROR);
        }
        return Result.success("处理异常",ErrorCodeEnum.SYSTEM_ERROR);



    }
}
