package com.workdatabase.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName("The_Map")
public class TheMap {
    @TableId("fileId")
    private String fileid;

    @TableField("fName")
    private String fName;

    private String longitude;

    private String latitude;

    private Integer id;

    private String message;
}