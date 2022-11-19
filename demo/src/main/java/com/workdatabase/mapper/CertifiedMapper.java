package com.workdatabase.mapper;

import com.workdatabase.domain.Certified;
import com.workdatabase.domain.CertifiedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CertifiedMapper {
    long countByExample(CertifiedExample example);

    int deleteByExample(CertifiedExample example);

    int deleteByPrimaryKey(String openid);

    int insert(Certified record);

    int insertSelective(Certified record);

    List<Certified> selectByExample(CertifiedExample example);

    Certified selectByPrimaryKey(String openid);

    int updateByExampleSelective(@Param("record") Certified record, @Param("example") CertifiedExample example);

    int updateByExample(@Param("record") Certified record, @Param("example") CertifiedExample example);

    int updateByPrimaryKeySelective(Certified record);

    int updateByPrimaryKey(Certified record);
}