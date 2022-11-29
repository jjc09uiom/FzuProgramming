package com.workdatabase.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("question")
public class question {
    @TableId("keyId")
    private Integer keyId;
    private String question;
    private String A;
    private String B;
    private String C;
    private String D;
    private String correct;
}
