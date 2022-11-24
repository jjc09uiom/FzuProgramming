package com.workdatabase.mapper;

import com.workdatabase.domain.TheMap;
import com.workdatabase.domain.TheMapExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TheMapMapper {
    long countByExample(TheMapExample example);

    int deleteByExample(TheMapExample example);

    int deleteByPrimaryKey(String fileid);

    int insert(TheMap record);

    int insertSelective(TheMap record);

    List<TheMap> selectByExample(TheMapExample example);

    TheMap selectByPrimaryKey(String fileid);

    int updateByExampleSelective(@Param("record") TheMap record, @Param("example") TheMapExample example);

    int updateByExample(@Param("record") TheMap record, @Param("example") TheMapExample example);

    int updateByPrimaryKeySelective(TheMap record);

    int updateByPrimaryKey(TheMap record);

    List<TheMap> list();
}