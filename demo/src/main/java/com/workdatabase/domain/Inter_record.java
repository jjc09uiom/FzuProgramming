package com.workdatabase.domain;

public class Inter_record {
    public String time;//答题时间
    public int gain;//获得分数
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getGain() {
        return gain;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    @Override
    public String toString() {
        return "Inter_record{" +
                "time='" + time + '\'' +
                ", gain=" + gain +
                '}';
    }
}
