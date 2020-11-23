package com.qiutong.work.enums;

import java.util.Arrays;
import java.util.Map;

/**
 * @Classname BizCodeEnum
 * @Description HOPE NO BUGS!
 * @Date 2020/11/23 下午11:02
 * @Created by Wayne Zhi
 */
public enum BizCodeEnum {
    NORMAL(20,"成功"),
    LOGIN_FAIL(10, "登陆失败!"),
    EMPTY_PARAMETER(400, "参数为异常或者空!");


    private final int code;
    private final String desc;

    BizCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }


    public static BizCodeEnum findByCode(int code){
        for (BizCodeEnum bizCodeEnum : BizCodeEnum.values()){
            if (bizCodeEnum.code==code){
                return bizCodeEnum;
            }
        }
        return null;
    }

    public static BizCodeEnum findByDesc(String desc){
        for (BizCodeEnum bizCodeEnum : BizCodeEnum.values()){
            if (bizCodeEnum.desc.equals(desc)){
                return bizCodeEnum;
            }
        }

        return null;
    }
}
