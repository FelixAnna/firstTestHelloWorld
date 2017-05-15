package com.xiangyong.exception;

/**
 * Created by yuxiangyong on 2017/5/6.
 */
public class Error {
    private String message;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Error(int code, String message){
        this.code=code;
        this.message=message;
    }
}
