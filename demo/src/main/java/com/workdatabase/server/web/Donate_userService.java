package com.workdatabase.server.web;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.workdatabase.domain.donate_user;
import com.workdatabase.mapper.Donate_userMapper;
import com.workdatabase.mapper.MybatisPlus.Donate_userMapperPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Donate_userService extends ServiceImpl<Donate_userMapperPlus, donate_user> {

    @Autowired
    private Donate_userMapper donate_userMapper;

    public void Update(Integer donate_id,String openid,Integer push){
        Integer flag = donate_userMapper.Select_Exit(donate_id,openid);
        if(flag == 0){
            donate_userMapper.Insert(donate_id,openid,push);
        }
        else {
            donate_user d = donate_userMapper.Select(donate_id,openid);
            push += d.getEverpush();
            donate_userMapper.Update(donate_id,openid,push);
        }
    }
}
