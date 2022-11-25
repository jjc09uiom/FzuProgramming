package com.workdatabase.domain;

public class Inter_Static {
    public String name;//姓名
    public String gra_time;//毕业年份
    public String major;//专业
    public int total_inter;//总积分

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGra_time() {
        return gra_time;
    }

    public void setGra_time(String gra_time) {
        this.gra_time = gra_time;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getTotal_inter() {
        return total_inter;
    }

    public void setTotal_inter(int total_inter) {
        this.total_inter = total_inter;
    }

    @Override
    public String toString() {
        return "inter_Static{" +
                "name='" + name + '\'' +
                ", gra_time='" + gra_time + '\'' +
                ", major='" + major + '\'' +
                ", total_inter=" + total_inter +
                '}';
    }
}
