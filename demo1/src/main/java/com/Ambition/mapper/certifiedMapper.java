package com.Ambition.mapper;

import com.Ambition.pojo.certified;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface certifiedMapper {
    certified searchClassBy(String openId);
    List<certified> searchClass(int banji,String openId);
}
