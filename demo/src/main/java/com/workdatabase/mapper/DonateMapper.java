package com.workdatabase.mapper;


import com.workdatabase.domain.donate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DonateMapper {
    public donate SelectById(Integer id);                //查找捐款目标并返回对应数据
    public void Update(Integer id,Integer update_current);     //更新数据库，如果捐款进度满了？

    public List<donate> SelectPage(Integer pageNum,Integer pageSize,String name);

    public Integer SelectCount(String name);

    public Integer DeleteById(Integer id);
}
