package com.qiutong.work.base;

import com.qiutong.work.enums.BizCodeEnum;
import com.qiutong.work.enums.ErrorCodeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -2608412917957842474L;

    private T data;

    private Integer code = ErrorCodeEnum.SYSTEM_ERROR.getCode();

    private String message = ErrorCodeEnum.SYSTEM_ERROR.getText();

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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

    public static <T> Result<T> fail(String msg,ErrorCodeEnum codeEnum) {
        Result<T> result = fail();
        result.setMessage(msg);
        result.setCode(codeEnum.getCode());
        return result;
    }
    public static <T> Result<T> fail(String msg, BizCodeEnum bizCodeEnum) {
        Result<T> result = fail();
        result.setMessage(msg);
        result.setCode(bizCodeEnum.getCode());
        return result;
    }
    public static <T> Result<T> fail( BizCodeEnum bizCodeEnum) {
        Result<T> result = fail();
        result.setMessage(bizCodeEnum.getDesc());
        result.setCode(bizCodeEnum.getCode());
        return result;
    }

    public static <T> Result<T> fail(ErrorCodeEnum codeEnum) {
        Result<T> result = new Result<>();
        result.setCode(codeEnum.getCode());
        result.setMessage(codeEnum.getText());
        return result;
    }

    public static <T> Result<T> success(String msg, BizCodeEnum bizCodeEnum) {
        Result<T> result = new Result<>();
        result.setCode(bizCodeEnum.getCode());
        result.setMessage(msg);
        return result;
    }

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setMessage("执行成功!");
        result.setCode(0);
        return result;
    }

    public static <T> Result<T> success(T t) {
        Result<T> result = success();
        result.setData(t);
        return result;
    }

    public static <T> Result<T> success(T t,String msg, BizCodeEnum bizCodeEnum) {
        Result<T> result = success();
        result.setData(t);
        result.setCode(bizCodeEnum.getCode());
        result.setMessage(msg);
        return result;
    }

    public static <T> Result<T> success(Result<T> result) {
        if(result == null) {
            return success();
        } else {
            result.setMessage("执行成功!");
            result.setCode(0);
            return result;
        }
    }



}
