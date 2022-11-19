package com.workdatabase.server;

import com.workdatabase.domain.Certified;
import com.workdatabase.domain.CertifiedExample;
import com.workdatabase.mapper.CertifiedMapper;
import com.workdatabase.req.CertifiedReq;
import com.workdatabase.resp.CertifiedResp;
import com.workdatabase.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserloginServer {


    @Resource
    private CertifiedMapper certifiedMapper;



    public Certified selectByPrimaryKeyOpenId(String openid){
        CertifiedExample certifiedExample=new CertifiedExample();
        CertifiedExample.Criteria criteria=certifiedExample.createCriteria();
        criteria.andOpenidEqualTo(openid);
        List<Certified> list=certifiedMapper.selectByExample(certifiedExample);
        if(ObjectUtils.isEmpty(list)){
            Certified certified=new Certified();
            certified.setOpenid(openid);
            certified.setName("无");
            certified.setRoommatename(" ");
            certified.setPhonenumber(" ");
            certified.setGraduationtime(" ");
            certified.setMajor(" ");
            certified.setBanji(0);
            certified.setDepartment(" ");
            return certified;
        }else {
            return list.get(0);
        }

    }



    public CertifiedResp identify(CertifiedReq certifiedReq){

        Certified DB=selectByPrimaryKeyOpenId(certifiedReq.getOpenid());
        if (DB.getName().equals("无")){
            CertifiedResp resp= CopyUtil.copy(DB,CertifiedResp.class);
            resp.setOpenid(certifiedReq.getOpenid());
            resp.setFlag(false);
            return resp;
        }else {
            CertifiedResp resp= CopyUtil.copy(DB,CertifiedResp.class);
            resp.setOpenid(certifiedReq.getOpenid());
            resp.setFlag(true);
            return resp;
        }
    }

    public void insert(CertifiedReq req){
        Certified certified=CopyUtil.copy(req,Certified.class);
        certifiedMapper.insert(certified);
    }
}
