package com.workdatabase.req;

public class IdentifySaveReq {

    private String name;

    private String roommatename;

    private String phonenumber;

    private String graduationtime;

    private String major;

    private Integer banji;

    private String department;

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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", roommatename=").append(roommatename);
        sb.append(", phonenumber=").append(phonenumber);
        sb.append(", graduationtime=").append(graduationtime);
        sb.append(", major=").append(major);
        sb.append(", banji=").append(banji);
        sb.append(", department=").append(department);
        sb.append("]");
        return sb.toString();
    }
}