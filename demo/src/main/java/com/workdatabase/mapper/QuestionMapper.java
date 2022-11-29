package com.workdatabase.mapper;

import com.workdatabase.domain.question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    /************************   "后台Web管理系统" 区域 *************************************************************/
    public List<question> SelectPage(Integer pageNum, Integer pageSize, String question);
    public Integer SelectCount(String question);
    public Integer DeleteById(Integer keyId);

    /************************   "后台Web管理系统" 区域 *************************************************************/
}
