package com.workdatabase.domain;

public class Voice {
    private Integer keyid;

    private String greeting;

    public Integer getKeyid() {
        return keyid;
    }

    public void setKeyid(Integer keyid) {
        this.keyid = keyid;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", keyid=").append(keyid);
        sb.append(", greeting=").append(greeting);
        sb.append("]");
        return sb.toString();
    }
}