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
    EMPTY_PARAMETER(400, "参数为空!");


    private final int code;
    private final String text;

    private static final Map<Integer, ErrorCodeEnum> CODE_ENUM_MAP = Maps.uniqueIndex(Arrays.asList(values()), ErrorCodeEnum::getCode);

    public static String getText(int code) {
        return CODE_ENUM_MAP.get(code).getText();
    }
}
