package com.workdatabase.req;

import javax.validation.constraints.NotNull;

public class IdentifyQueryReq {

    private String openId;

    @NotNull(message = "【姓名】不能为空")
    private String name;
    @NotNull(message = "【大学舍友】不能为空")
    private String roommatename;
    @NotNull(message = "【手机号】不能为空")
    private String phonenumber;
    @NotNull(message = "【毕业年份】不能为空")
    private String graduationtime;
    @NotNull(message = "【学院】不能为空")
    private String academyname;
    @NotNull(message = "【班级】不能为空")
    private Integer banji;
    @NotNull(message = "【社团】不能为空")
    private String department;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", roommatename=").append(roommatename);
        sb.append(", phonenumber=").append(phonenumber);
        sb.append(", graduationtime=").append(graduationtime);
        sb.append(", academyname=").append(academyname);
        sb.append(", banji=").append(banji);
        sb.append(", department=").append(department);
        sb.append("]");
        return sb.toString();
    }
}