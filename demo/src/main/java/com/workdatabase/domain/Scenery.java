package com.workdatabase.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scenery {
    @TableId("")
    private String Sname;
    private String Sloc;
    private String introduction;
    private String picture;

}
