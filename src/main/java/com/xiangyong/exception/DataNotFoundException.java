package com.xiangyong.exception;

/**
 * Created by yuxiangyong on 2017/5/6.
 */
public class DataNotFoundException extends RuntimeException {
    private long id;
    public DataNotFoundException(long id){
        this.id =id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString()
    {
        if(this.id>0) {
            return String.format("Data not found:id = %d.", this.id);
        } else {
            return "Data not found.";
        }
    }
}
