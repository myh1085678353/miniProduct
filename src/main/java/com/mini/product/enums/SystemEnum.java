package com.mini.product.enums;

public enum SystemEnum {
    Error_User_Deleted("该账号已经删除！"),
    Success_User_Login("登陆成功！"),
    Error_User("用户名或密码错误，请重试！"),
    Error_Login_Action("请重新登录！"),
    Success_User_LoginOut("登出成功！"),
    Error_User_Not_Exist("账号不存在");
    private final String message;

    SystemEnum(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
