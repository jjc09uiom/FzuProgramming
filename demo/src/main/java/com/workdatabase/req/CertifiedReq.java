package com.workdatabase.req;

public class CertifiedReq {


    private String openid;

    private String name;

    private String roommatename;

    private String phonenumber;

    private String graduationtime;

    private String academyname;

    private Integer banji;

    private String department;



    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoommatename() {
        return roommatename;
    }

    public void setRoommatename(String roommatename) {
        this.roommatename = roommatename;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGraduationtime() {
        return graduationtime;
    }

    public void setGraduationtime(String graduationtime) {
        this.graduationtime = graduationtime;
    }

    public String getAcademyname() {
        return academyname;
    }

    public void setAcademyname(String academyname) {
        this.academyname = academyname;
    }

    public Integer getBanji() {
        return banji;
    }

    public void setBanji(Integer banji) {
        this.banji = banji;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "CertifiedReq{" +
                "openid='" + openid + '\'' +
                ", name='" + name + '\'' +
                ", roommatename='" + roommatename + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", graduationtime='" + graduationtime + '\'' +
                ", academyname='" + academyname + '\'' +
                ", banji=" + banji +
                ", department='" + department + '\'' +
                '}';
    }
}