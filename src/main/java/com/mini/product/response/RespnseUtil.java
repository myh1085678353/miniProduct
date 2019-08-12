package com.mini.product.response;

import java.util.Map;

public class RespnseUtil {

    public Map<String,Object> data;
    public String message = "";
    public long time;
    public Integer code;

    public RespnseUtil(){

    }

    public RespnseUtil(Map<String,Object> data, String message,Integer code){
        this.data = data;
        this.message = message;
        this.time = System.currentTimeMillis();
        this.code = code;
    }

    public RespnseUtil(String message,Integer code){
        this.message = message;
        this.time = System.currentTimeMillis();
        this.code = code;
    }

    public static RespnseUtil SUCCESS(){
        return SUCCESS("请求成功");
    }

    public static RespnseUtil SUCCESS(String message){
        return new RespnseUtil(message,200);
    }

    public static RespnseUtil SUCCESS(Map<String,Object> data,String message){
        return new RespnseUtil(data,message,200);
    }

    public static RespnseUtil SUCCESS(Map<String,Object> data){
        return SUCCESS(data,"请求成功");
    }

    public static RespnseUtil Error(){
        return Error("请求失败");
    }

    public static RespnseUtil Error(String message){
        return new RespnseUtil(message,404);
    }
}
