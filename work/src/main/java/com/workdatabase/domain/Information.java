package com.workdatabase.domain;


public class Information {
    private String name;

    private String colleageName;

    private String phoneNumber;

    private String graduationTime;

    private String schoolName;

    private Integer banji;

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

    public String getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(String graduationTime) {
        this.graduationTime = graduationTime;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getBanji() {
        return banji;
    }

    public void setBanji(Integer banji) {
        this.banji = banji;
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
        sb.append(", schoolName=").append(schoolName);
        sb.append(", banji=").append(banji);
        sb.append(", community=").append(community);
        sb.append("]");
        return sb.toString();
    }
}