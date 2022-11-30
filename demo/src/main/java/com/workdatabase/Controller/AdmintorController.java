package com.workdatabase.Controller;


import com.workdatabase.req.AdmintorLoginReq;
import com.workdatabase.resp.AdmintorLoginResp;
import com.workdatabase.resp.CommonResp;
import com.workdatabase.server.web.AdmintorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdmintorController {
    @Resource
    private AdmintorService admintorService;


    @PostMapping("/login")
    public CommonResp login(@RequestBody@Valid AdmintorLoginReq req){
        CommonResp<AdmintorLoginResp> resp=new CommonResp();

        AdmintorLoginResp admintorLoginResp= admintorService.login(req);

        resp.setContent(admintorLoginResp);
        return resp;
    }

}
