package com.Ambition.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class certified {
    private String openId;
    private String name;
    private String roommateName;
    private String phonenumber;
    private String graduationTime;
    private String major;
    private int banji;
    private String department;
}
