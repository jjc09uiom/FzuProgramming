package com.workdatabase.mapper;

import com.workdatabase.domain.Voice;
import com.workdatabase.domain.VoiceExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VoiceMapper {
    long countByExample(VoiceExample example);

    int deleteByExample(VoiceExample example);

    int deleteByPrimaryKey(Integer keyid);

    int insert(Voice record);

    int insertSelective(Voice record);

    List<Voice> selectByExample(VoiceExample example);

    Voice selectByPrimaryKey(Integer keyid);

    int updateByExampleSelective(@Param("record") Voice record, @Param("example") VoiceExample example);

    int updateByExample(@Param("record") Voice record, @Param("example") VoiceExample example);

    int updateByPrimaryKeySelective(Voice record);

    int updateByPrimaryKey(Voice record);

    List<Voice> list();
    /************************   "后台Web管理系统" 区域 *************************************************************/
    public List<Voice> SelectPage(Integer pageNum,Integer pageSize,String greeting);
    public Integer SelectCount(String greeting);
    public Integer DeleteById(Integer keyId);

    /************************   "后台Web管理系统" 区域 *************************************************************/
}