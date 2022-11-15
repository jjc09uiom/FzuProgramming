package com.workdatabase.resp;

import java.util.Date;

public class InfidentifyResp {
    private String name;

    private String colleageName;

    private String phoneNumber;

    private Date graduationTime;

    private String shcoolName;

    private Long CLASS;

    private String community;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColleageName() {
        return colleageName;
    }

    public void setColleageName(String colleageName) {
        this.colleageName = colleageName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(Date graduationTime) {
        this.graduationTime = graduationTime;
    }

    public String getShcoolName() {
        return shcoolName;
    }

    public void setShcoolName(String shcoolName) {
        this.shcoolName = shcoolName;
    }

    public Long getCLASS() {
        return CLASS;
    }

    public void setClass(Long Class) {
        this.CLASS = Class;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", colleageName=").append(colleageName);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", graduationTime=").append(graduationTime);
        sb.append(", shcoolName=").append(shcoolName);
        sb.append(", class=").append(CLASS);
        sb.append(", community=").append(community);
        sb.append("]");
        return sb.toString();
    }
}