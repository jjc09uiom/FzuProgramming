package com.workdatabase.Controller;

import com.workdatabase.req.InformationQueryReq;
import com.workdatabase.resp.CommonResp;
import com.workdatabase.resp.InfidentifyResp;
import com.workdatabase.server.InfServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class InfController {

    @Resource
    private InfServer infServer;

    @PostMapping("/Inf/identify")
    public CommonResp identify(InformationQueryReq req){
        CommonResp<InfidentifyResp> resp=new CommonResp<>();
        InfidentifyResp infidentifyResp=infServer.identify(req);

        resp.setContent(infidentifyResp);
        return resp;
    }

}
