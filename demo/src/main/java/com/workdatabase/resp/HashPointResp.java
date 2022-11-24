package com.workdatabase.resp;

public class HashPointResp {
    private String openid;

    private Integer keyid;

    private  Integer id;

    private String greeting;


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getKeyid() {
        return keyid;
    }

    public void setKeyid(Integer keyid) {
        this.keyid = keyid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        return "HashPointResp{" +
                "openid='" + openid + '\'' +
                ", keyid=" + keyid +
                ", id=" + id +
                ", greeting='" + greeting + '\'' +
                '}';
    }
}