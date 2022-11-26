package com.workdatabase.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voice {
    @TableId("keyId")
    private Integer keyId;

    private String greeting;
}