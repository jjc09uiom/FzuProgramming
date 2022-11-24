package com.Ambition.service;

import com.Ambition.mapper.certifiedMapper;
import com.Ambition.pojo.certified;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class certifiedServiceImpl implements certifiedService {

    @Resource
    private certifiedMapper certifiedMapper;

    public  List<certified> getCertifiedById(String openId) {
        certified certifiedId = certifiedMapper.searchClassBy(openId);
        List<certified> certifieds = certifiedMapper.searchClass(certifiedId.getBanji(),openId);
        return  certifieds;
    }
}
