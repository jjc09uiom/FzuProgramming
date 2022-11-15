package com.workdatabase.req;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class InformationQueryReq {
    @NotNull(message = "【姓名】不能为空")
    private String name;
    @NotNull(message = "【大学舍友】不能为空")
    private String colleageName;
    @NotNull(message = "【手机号】不能为空")
    private String phoneNumber;
    @NotNull(message = "【毕业年份】不能为空")
    private String graduationTime;
    @NotNull(message = "【专业】不能为空")
    private String shcoolName;
    @NotNull(message = "【班级】不能为空")
    private Long CLASS;
    @NotNull(message = "【社团】不能为空")
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