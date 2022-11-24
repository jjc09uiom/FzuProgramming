package com.workdatabase.mapper;

import com.workdatabase.domain.HashPoint;
import com.workdatabase.domain.HashPointExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HashPointMapper {
    long countByExample(HashPointExample example);

    int deleteByExample(HashPointExample example);

    int deleteByPrimaryKey(String openid);

    int insert(HashPoint record);

    int insertSelective(HashPoint record);

    List<HashPoint> selectByExample(HashPointExample example);

    HashPoint selectByPrimaryKey(String openid);

    int updateByExampleSelective(@Param("record") HashPoint record, @Param("example") HashPointExample example);

    int updateByExample(@Param("record") HashPoint record, @Param("example") HashPointExample example);

    int updateByPrimaryKeySelective(HashPoint record);

    int updateByPrimaryKey(HashPoint record);
}