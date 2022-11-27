package com.workdatabase.mapper;

import com.workdatabase.domain.Scenery;
import com.workdatabase.domain.Voice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SceneryMapper {
    public List<Scenery> SelectPage(Integer pageNum, Integer pageSize, String sname);
    public Integer SelectCount(String sname);
    public Integer DeleteByName(String sname);
}
