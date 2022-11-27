package com.workdatabase.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class money {
    private Integer id;
    private String title;
    private String description;
    private String picture_filed;
    private Integer current;
    private Integer target;
}
