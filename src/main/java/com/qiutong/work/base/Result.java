package com.qiutong.work.base;

import com.qiutong.work.enums.ErrorCodeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -2608412917957842474L;

    private T data;

    private Integer errorCode = ErrorCodeEnum.SYSTEM_ERROR.getCode();

    private String message = ErrorCodeEnum.SYSTEM_ERROR.getText();

    public Result() {
    }

    public static <T> Result<T> fail() {
        return new Result<>();
    }

    public static <T> Result<T> fail(String msg) {
        Result<T> result = fail();
        result.setMessage(msg);
        return result;
    }

    public static <T> Result<T> fail(ErrorCodeEnum codeEnum) {
        Result<T> result = new Result<>();
        result.setErrorCode(codeEnum.getCode());
        result.setMessage(codeEnum.getText());
        return result;
    }

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setMessage("执行成功!");
        result.setErrorCode(0);
        return result;
    }

    public static <T> Result<T> success(T t) {
        Result<T> result = success();
        result.setData(t);
        return result;
    }

    public static <T> Result<T> success(Result<T> result) {
        if(result == null) {
            return success();
        } else {
            result.setMessage("执行成功!");
            result.setErrorCode(0);
            return result;
        }
    }

}
