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
@TableName("donate_user")
public class donate_user {
    @TableId("donate_id")
    private Integer donateid;        //捐款对象名字
    @TableField("openid")
    private String openid;      //用户标识符
    @TableField("ever_push")
    private Integer everpush;
}
