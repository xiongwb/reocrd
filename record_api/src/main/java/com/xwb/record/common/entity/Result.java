package com.xwb.record.common.entity;

public class Result {
    public Result() {
    }

    public static ResponseMessage<String> success() {
        return new ResponseMessage<String>(ResponseMessageCodeEnum.SUCCESS.getCode(), "", true);
    }

    public static <T> ResponseMessage<T> success(String code, T t) {
        return new ResponseMessage<T>(code, "", true, t);
    }

    public static <T> ResponseMessage<T> success(String code, String message) {
        return new ResponseMessage<T>(code, message);
    }

    public static <T> ResponseMessage<T> success(String code, String message, T t) {
        return new ResponseMessage<T>(code, message, true, t);
    }

    public static <T> ResponseMessage<T> success(T t) {
        return new ResponseMessage<T>(ResponseMessageCodeEnum.SUCCESS.getCode(), "", true, t);
    }

    public static ResponseMessage<Object> error() {
        return error("");
    }

    public static ResponseMessage<Object> error(String message) {
        return error(ResponseMessageCodeEnum.ERROR.getCode(), message);
    }

    public static ResponseMessage<Object> error(String code, String message) {
        return error(code, message, (Object)null);
    }

    public static <T> ResponseMessage<T> error(String code, String message, T t) {
        return new ResponseMessage<T>(code, message, false, t);
    }
}