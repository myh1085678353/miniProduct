package com.mini.product.common.response;

import java.util.Map;

public class ResponseUtil_Miao<T> {
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

    public ResponseUtil_Miao(){

    }

    public ResponseUtil_Miao(T data, String message, Integer code){
        this.data = data;
        this.message = message;
        this.time = System.currentTimeMillis();
        this.code = code;
    }

    public ResponseUtil_Miao(String message, Integer code){
        this.message = message;
        this.time = System.currentTimeMillis();
        this.code = code;
    }

    public static ResponseUtil_Miao SUCCESS(){
        return SUCCESS("请求成功");
    }

    public static ResponseUtil_Miao SUCCESS(String message){
        return new ResponseUtil_Miao(message,200);
    }

    public static ResponseUtil_Miao SUCCESS(Map<String,Object> data, String message){
        return new ResponseUtil_Miao(data,message,200);
    }

    public static ResponseUtil_Miao SUCCESS(Map<String,Object> data){
        return SUCCESS(data,"请求成功");
    }

    public static ResponseUtil_Miao Error(){
        return Error("请求失败");
    }

    public static ResponseUtil_Miao Error(String message){
        return new ResponseUtil_Miao(message,404);
    }
}
