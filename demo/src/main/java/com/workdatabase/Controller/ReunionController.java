package com.workdatabase.Controller;

import com.workdatabase.req.CertifiedReq;
import com.workdatabase.resp.CommonResp;
import com.workdatabase.server.ReunionServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ReunionController {

    @Resource
    private ReunionServer reunionServer;



    @PostMapping("/Weixin/Reunion")
    public CommonResp Reunion(String openid){
        CommonResp resp = new CommonResp<>();
        List<CertifiedReq> list=reunionServer.getReunion(openid);

        resp.setContent(list);
        return resp;
    }

}