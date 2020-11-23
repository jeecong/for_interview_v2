package com.qiutong.work.enums;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;


@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {


    SYSTEM_ERROR(500, "执行失败!"),
    EMPTY_PARAMETER(400, "参数为异常或者空!");


    private final int code;
    private final String text;


    ErrorCodeEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    private static final Map<Integer, ErrorCodeEnum> CODE_ENUM_MAP = Maps.uniqueIndex(Arrays.asList(values()), ErrorCodeEnum::getCode);

    public static String getText(int code) {
        return CODE_ENUM_MAP.get(code).getText();
    }

    public static ErrorCodeEnum findByCode(int code){
        for (ErrorCodeEnum errorCodeEnum : ErrorCodeEnum.values()){
            if (errorCodeEnum.code==code){
                return errorCodeEnum;
            }
        }
        return null;
    }

    public static ErrorCodeEnum findByText(String text){
        for (ErrorCodeEnum errorCodeEnum : ErrorCodeEnum.values()){
            if (errorCodeEnum.text.equals(text)){
                return errorCodeEnum;
            }
        }

        return null;
    }
}
