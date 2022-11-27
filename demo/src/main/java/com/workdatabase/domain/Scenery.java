package com.workdatabase.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scenery {
    @TableId("sname")
    private String sname;

    private String sloc;

    private String introduction;

    private String picture;

}
