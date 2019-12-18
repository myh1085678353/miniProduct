package com.mini.product.response;

import java.util.Map;

public class ResponseUtil<T> {
    //泛型T储存任何类型，返回给前端
    public T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String message = "";
    public long time;
    public Integer code;

    public ResponseUtil(){

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

    public static ResponseUtil SUCCESS(){
        return SUCCESS("请求成功");
    }

    public static ResponseUtil SUCCESS(String message){
        return new ResponseUtil(message,200);
    }

    public static ResponseUtil SUCCESS(Map<String,Object> data, String message){
        return new ResponseUtil(data,message,200);
    }

    public static ResponseUtil SUCCESS(Map<String,Object> data){
        return SUCCESS(data,"请求成功");
    }

    public static ResponseUtil Error(){
        return Error("请求失败");
    }

    public static ResponseUtil Error(String message){
        return new ResponseUtil(message,404);
    }
}
