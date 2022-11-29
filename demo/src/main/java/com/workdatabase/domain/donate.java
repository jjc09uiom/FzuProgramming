package com.workdatabase.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class donate {
    @TableId("id")
    private Integer id;
    private String name;
    private String introduction;
    private Integer need;
    private Integer had;
    private Float prog;
    private String picture;
}
