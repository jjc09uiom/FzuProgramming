package com.workdatabase.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.workdatabase.WeiXin.WeixinConstants;
import com.workdatabase.config.HttpClientUtils;
import com.workdatabase.domain.Certified;
import com.workdatabase.domain.CertifiedExample;
import com.workdatabase.mapper.CertifiedMapper;
import com.workdatabase.req.CertifiedReq;
import com.workdatabase.req.IdentifyQueryReq;
import com.workdatabase.resp.CertifiedResp;
import com.workdatabase.resp.CommonResp;
import com.workdatabase.resp.IdentifyResp;
import com.workdatabase.server.IdenServer;
import com.workdatabase.server.UserloginServer;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IdenController {

    @Resource
    private IdenServer idenServer;

    @Resource
    private UserloginServer userloginServer;

    @Resource
    private CertifiedMapper certifiedMapper;

    public boolean judgeByOpenId(String openid){
        CertifiedExample certifiedExample=new CertifiedExample();
        CertifiedExample.Criteria criteria=certifiedExample.createCriteria();
        criteria.andOpenidEqualTo(openid);
        List<Certified>list=certifiedMapper.selectByExample(certifiedExample);
        if(ObjectUtils.isEmpty(list)){
            //表示认证当中不存在这个用户，返回true
            return true;
        }else {
            return false;
        }
    }


    @PostMapping("/WeixinUser/Login")
    public CommonResp Login(String code){

        CommonResp<CertifiedResp> resp=new CommonResp();
        Map<String, String> param = new HashMap<>();
        param.put("appid", WeixinConstants.WX_LOGIN_APP_ID);
        param.put("secret", WeixinConstants.WX_LOGIN_SECRET);
        param.put("js_code", code);
        param.put("grant_type", WeixinConstants.WX_LOGIN_GRANT_TYPE);
        // 发送请求
        String wxResult= HttpClientUtils.doGet(WeixinConstants.WX_LOGIN_URL,param);
        JSONObject jsonObject = JSON.parseObject(wxResult);

        // 获取参数返回的
        String open_id = jsonObject.get("openid").toString();

        CertifiedReq certifiedReq=new CertifiedReq();
        certifiedReq.setOpenid(open_id);
        CertifiedResp result=userloginServer.identify(certifiedReq);
        resp.setContent(result);
        //返回带含有openid的所用数据
        return resp;
    }

    @PostMapping("/WeixinUser/identify")
    public  CommonResp WeixinIdentify(IdentifyQueryReq req){
        CommonResp<IdentifyResp> resp=new CommonResp<>();
        IdentifyResp identify=idenServer.identify(req);

        if(identify.isFlag()) {
            //识别成功
            if(judgeByOpenId(req.getOpenId())){
                //认证当中没有这个用户，需要将此用户存入认证表中
                CertifiedReq certifiedReq = new CertifiedReq();
                certifiedReq.setOpenid(req.getOpenId());
                certifiedReq.setName(req.getName());
                certifiedReq.setRoommatename(req.getRoommatename());
                certifiedReq.setPhonenumber(req.getPhonenumber());
                certifiedReq.setGraduationtime(req.getGraduationtime());
                certifiedReq.setMajor(req.getMajor());
                certifiedReq.setBanji(req.getBanji());
                certifiedReq.setDepartment(req.getDepartment());
                userloginServer.insert(certifiedReq);
            }
        }
        identify.setOpenid(req.getOpenId());
        identify.setName(req.getName());
        identify.setRoommatename(req.getRoommatename());
        identify.setPhonenumber(req.getPhonenumber());
        identify.setBanji(req.getBanji());
        identify.setDepartment(req.getDepartment());
        identify.setMajor(req.getMajor());
        identify.setGraduationtime(req.getGraduationtime());
        resp.setContent(identify);
        return resp;
    }


    @PostMapping("/identify")
    public CommonResp Identify(IdentifyQueryReq req){
        CommonResp<IdentifyResp> resp=new CommonResp<>();
        IdentifyResp identify=idenServer.identify(req);

        resp.setContent(identify);
        return resp;
    }


}
