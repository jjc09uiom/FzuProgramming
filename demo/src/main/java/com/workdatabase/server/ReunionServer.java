package com.workdatabase.server;


import com.workdatabase.domain.Certified;
import com.workdatabase.domain.CertifiedExample;
import com.workdatabase.mapper.CertifiedMapper;
import com.workdatabase.req.CertifiedReq;
import com.workdatabase.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReunionServer {

    @Resource
    private CertifiedMapper certifiedMapper;

    public Certified selectByPrimaryKeyLoginName(String openid){
        CertifiedExample certifiedExample=new CertifiedExample();
        CertifiedExample.Criteria criteria=certifiedExample.createCriteria();
        criteria.andOpenidEqualTo(openid);
        List<Certified> list=certifiedMapper.selectByExample(certifiedExample);
        if(ObjectUtils.isEmpty(list)){
            Certified certified = new Certified();
            certified.setName(openid);
            certified.setBanji(0);
            certified.setGraduationtime("null");
            certified.setRoommatename("null");
            certified.setPhonenumber("null");
            certified.setDepartment("null");
            certified.setMajor("null");
            certified.setOpenid("null");
            return certified;
        }else {
            return list.get(0);
        }
    }

    public List<Certified> selectByBanjiAndGraduation(int banji,String time,String openid){
        CertifiedExample certifiedExample=new CertifiedExample();
        CertifiedExample.Criteria criteria=certifiedExample.createCriteria();
        criteria.andBanjiEqualTo(banji).andGraduationtimeEqualTo(time).andOpenidNotEqualTo(openid);
        List<Certified> list=certifiedMapper.selectByExample(certifiedExample);
        if(ObjectUtils.isEmpty(list)){
            return null;

        }else {
            return list;
        }
    }

    private List<Certified> selectByDepartmentAndGraduation(String dment,String time,String openid){
        CertifiedExample certifiedExample=new CertifiedExample();
        CertifiedExample.Criteria criteria=certifiedExample.createCriteria();
        criteria.andDepartmentEqualTo(dment).andGraduationtimeEqualTo(time).andOpenidNotEqualTo(openid);
        List<Certified> list=certifiedMapper.selectByExample(certifiedExample);
        if(ObjectUtils.isEmpty(list)){
            return null;
        }else {
            return list;
        }
    }



    public List<Certified> getReunion(String openid){

        Certified certified=selectByPrimaryKeyLoginName(openid);
        List<Certified> DB=selectByBanjiAndGraduation(certified.getBanji(),certified.getGraduationtime(),openid);


        return DB;
    }
    public List<Certified> dmentReunion(String openid){
        Certified certified=selectByPrimaryKeyLoginName(openid);
        List<Certified> DB=selectByDepartmentAndGraduation(certified.getDepartment(),certified.getGraduationtime(),openid);
        return DB;
    }
}
