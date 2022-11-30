package com.workdatabase.resp;

public class AdmintorLoginResp {
    private String loginName;


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "UserLoginResp{" +
                ", loginName='" + loginName + '\'' +
                '}';
    }
}