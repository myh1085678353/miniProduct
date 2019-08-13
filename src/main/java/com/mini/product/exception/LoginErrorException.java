package com.mini.product.exception;

import com.mini.product.enums.SystemEnum;

public class LoginErrorException extends Exception{

    public LoginErrorException(){
        super(SystemEnum.Error_Login_Action.toString());
    }
}
