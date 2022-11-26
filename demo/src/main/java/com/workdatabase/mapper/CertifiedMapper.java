package com.workdatabase.mapper;

import com.workdatabase.domain.Certified;
import com.workdatabase.domain.CertifiedExample;
import com.workdatabase.domain.Voice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
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

    /************************   "后台Web管理系统" 区域 *************************************************************/
    public List<Certified> Select_ByPage(Integer pageNum,Integer pageSize);
    public Integer DeleteById(String openId);
    /************************   "后台Web管理系统" 区域 *************************************************************/

}