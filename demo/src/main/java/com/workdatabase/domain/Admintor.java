package com.workdatabase.domain;

public class Admintor {
    private String admin;

    private String password;

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", admin=").append(admin);
        sb.append(", password=").append(password);
        sb.append("]");
        return sb.toString();
    }
}