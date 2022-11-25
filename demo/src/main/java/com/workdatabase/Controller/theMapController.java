package com.workdatabase.Controller;

import com.workdatabase.domain.HashPoint;
import com.workdatabase.domain.TheMap;
import com.workdatabase.domain.Voice;
import com.workdatabase.resp.CommonResp;
import com.workdatabase.resp.HashPointResp;
import com.workdatabase.server.GreetingServer;
import com.workdatabase.server.TheMapServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class theMapController {


    @Resource
    private TheMapServer theMapServer;

    @Resource
    private GreetingServer greetingServer;

    @GetMapping("/Weixin/GetMap")
    public CommonResp getMap(){
        CommonResp<List<TheMap>> resp=new CommonResp();
        List<TheMap> list=theMapServer.list();
        resp.setContent(list);
        return resp;
    }


    @GetMapping("/Weixin/greeting")
    public CommonResp getGreeting(){
        CommonResp<List<Voice>> resp = new CommonResp<>();
        List<Voice> list=greetingServer.list();
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/Weixin/addMessage")
    public CommonResp addMessage(String openid,int keyid,int id){
        HashPoint req=new HashPoint();
        req.setOpenid(openid);
        req.setKeyid(keyid);
        req.setId(id);
        theMapServer.addMessage(req);
        CommonResp resp = new CommonResp<>();
        resp.setContent(req);
        return resp;
    }


    @PostMapping("/Weixin/getMessage")
    public CommonResp getMessage(int id){
        CommonResp resp = new CommonResp<>();
        List<HashPointResp> list=theMapServer.findById(id);

        resp.setContent(list);
        return resp;
    }


}
