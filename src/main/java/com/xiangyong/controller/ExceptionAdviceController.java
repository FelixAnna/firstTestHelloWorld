package com.xiangyong.controller;

import com.xiangyong.exception.DataNotFoundException;
import com.xiangyong.exception.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by yuxiangyong on 2017/5/9.
 */
@ControllerAdvice
public class ExceptionAdviceController {
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Error notFoundError(DataNotFoundException e){
        if(e.getId()>0) {
            return new Error(4, String.format("Data not found:id = %d.", e.getId()));
        } else {
            return new Error(4, "Data not found.");
        }
    }
}
