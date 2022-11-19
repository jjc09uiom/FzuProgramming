package com.workdatabase.mapper;

import com.workdatabase.domain.Identify;
import com.workdatabase.domain.IdentifyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IdentifyMapper {
    long countByExample(IdentifyExample example);

    int deleteByExample(IdentifyExample example);

    int deleteByPrimaryKey(String name);

    int insert(Identify record);

    int insertSelective(Identify record);

    public List<Identify> list();

    List<Identify> selectByExample(IdentifyExample example);

    Identify selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") Identify record, @Param("example") IdentifyExample example);

    int updateByExample(@Param("record") Identify record, @Param("example") IdentifyExample example);

    int updateByPrimaryKeySelective(Identify record);

    int updateByPrimaryKey(Identify record);
}