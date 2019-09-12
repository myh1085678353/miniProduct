package com.mini.product.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

public class StringUtil {

    public static String setPassword(String password){
        String passMd5 = DigestUtils.md5Hex(password);
        if(passMd5 != null && !passMd5.equals("")){
            return passMd5;
        }
        return "";
    }

    public static boolean verify(String text,String md5){
        String md5Text = setPassword(text);
        if(md5Text.equalsIgnoreCase(md5)){
            System.out.println("md5验证通过");
            return true;
        }
        return false;
    }

    public static String getUUID32(){
        String uuid = UUID.randomUUID().toString().replace("-","").toLowerCase();
        return uuid;
    }
}
