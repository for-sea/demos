package com.demo.entity;

import lombok.Data;

@Data
public class Result<T>{
    private Boolean success = Boolean.TRUE;

    private T data;

    private Result(){}

    public static <T> Result<T> buildSuccess(T t) {
        Result<T> result = new Result<>();
        result.setData(t);
        return result;
    }
}
