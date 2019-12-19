package com.mini.product.common.response;

import com.mini.product.enums.SystemEnum;

import java.util.Map;

public class ResponseUtil<T> {
    //泛型T储存任何类型，返回给前端
    public T data;

    public String message = "";

    public long time;

    public Integer code;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ResponseUtil(){

    }

    public ResponseUtil(String message){
        this.message = message;
    }

    public ResponseUtil(T data, String message, Integer code){
        this.data = data;
        this.message = message;
        this.time = System.currentTimeMillis();
        this.code = code;
    }

    public ResponseUtil(String message, Integer code){
        this.message = message;
        this.time = System.currentTimeMillis();
        this.code = code;
    }


    public static <T>ResponseUtil<T> buildSuccess(){
        return new ResponseUtil(SystemEnum.Result_Success.toString());
    }



    public static ResponseUtil buildError(){
        return new ResponseUtil(SystemEnum.Result_Error.toString());
    }
}
