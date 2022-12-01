package com.workdatabase.server.web;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.workdatabase.domain.donate;
import com.workdatabase.mapper.MybatisPlus.DonateMapperPlus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonateService extends ServiceImpl<DonateMapperPlus, donate> {

    public List<Double> change(List<donate> data){
        List<Double> ans = new ArrayList<Double>();;

        for(donate t:data){
            Double d = t.getHad()*1.0/t.getNeed();
            int c =(int) (d * 100);
            d = (double) c / 100;
            ans.add(d);
        }
        return ans;
    }
}
