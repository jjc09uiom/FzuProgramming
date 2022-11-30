package com.workdatabase.mapper;

import com.workdatabase.domain.Admintor;
import com.workdatabase.domain.AdmintorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdmintorMapper {
    long countByExample(AdmintorExample example);

    int deleteByExample(AdmintorExample example);

    int deleteByPrimaryKey(String admin);

    int insert(Admintor record);

    int insertSelective(Admintor record);

    List<Admintor> selectByExample(AdmintorExample example);

    Admintor selectByPrimaryKey(String admin);

    int updateByExampleSelective(@Param("record") Admintor record, @Param("example") AdmintorExample example);

    int updateByExample(@Param("record") Admintor record, @Param("example") AdmintorExample example);

    int updateByPrimaryKeySelective(Admintor record);

    int updateByPrimaryKey(Admintor record);
}