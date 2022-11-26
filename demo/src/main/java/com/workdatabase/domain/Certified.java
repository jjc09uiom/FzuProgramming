package com.workdatabase.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Negative;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Certified {
    @TableId("openId")
    private String openid;

    private String name;

    private String roommatename;

    private String phonenumber;

    private String graduationtime;

    private String major;

    private Integer banji;

    private String department;
}