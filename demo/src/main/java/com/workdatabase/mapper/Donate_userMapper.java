package com.workdatabase.mapper;

import com.workdatabase.domain.donate_user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Donate_userMapper {

    //如果存在就返回 "id" !!!!
    public Integer Select_Exit(Integer donate_id,String openid);
    public Integer Update(Integer donate_id,String openid,Integer push);
    public Integer Select_Push(Integer donate_id,String openid);
    public Integer Insert(Integer donate_id,String openid,Integer push);

    public donate_user Select(Integer donate_id, String openid);
}
