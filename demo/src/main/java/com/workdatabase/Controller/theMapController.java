package com.workdatabase.Controller;

import com.workdatabase.domain.HashPoint;
import com.workdatabase.domain.Scenery;
import com.workdatabase.domain.TheMap;
import com.workdatabase.domain.Voice;
import com.workdatabase.mapper.TheMapMapper;
import com.workdatabase.resp.CommonResp;
import com.workdatabase.resp.HashPointResp;
import com.workdatabase.server.GreetingServer;
import com.workdatabase.server.TheMapServer;
import com.workdatabase.server.web.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class theMapController {

    @Autowired
    private TheMapMapper theMapMapper;

    @Autowired
    private SceneryService sceneryService;
    @Resource
    private TheMapServer theMapServer;

    @Resource
    private GreetingServer greetingServer;


    /*************************************   "后台Web管理系统"区域  ************************************************************************/
    //1.用分页的方式，返回当前景点信息
    @GetMapping("/theMap/page")
    public CommonResp page(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam String  fName){
        pageNum=(pageNum-1)*pageSize;
        fName = "%"+fName+"%";
        Map<String,Object> res = new HashMap<>();
        List<TheMap> data = theMapMapper.SelectPage(pageNum,pageSize,fName);
        Integer total = theMapMapper.SelectCount(fName);
        res.put("data" , data);
        res.put("total" , total);
        CommonResp< Map<String,Object> > commonResp = new CommonResp();
        commonResp.setContent(res);
        commonResp.setSuccess(true);
        commonResp.setMessage("查找成功。");
        return commonResp;
    }
    //2.新增或者修改
    @PostMapping("/theMap/save")
    public CommonResp save(@RequestBody TheMap theMap){
        boolean flag = sceneryService.saveOrUpdate(theMap);
        CommonResp< List<TheMap> > commonResp = new CommonResp();
        if(flag){
            commonResp.setContent(null);
            commonResp.setSuccess(true);
            commonResp.setMessage("新增或者修改成功。");
        }
        else {
            commonResp.setContent(null);
            commonResp.setSuccess(false);
            commonResp.setMessage("新增或者修改失败。");
        }
        return commonResp;
    }
    //3.删除
    @PostMapping("/theMap/delete")
    public CommonResp delete(@RequestBody TheMap theMap){
        Integer flag = theMapMapper.DeleteById(theMap.getFileId());
        CommonResp< List<TheMap> > commonResp = new CommonResp();
        if(flag > 0) {
            commonResp.setContent(null);
            commonResp.setSuccess(true);
            commonResp.setMessage("删除成功。");
        }
        else {
            commonResp.setContent(null);
            commonResp.setSuccess(false);
            commonResp.setMessage("删除失败。");
        }
        return commonResp;
    }
    /*************************************   "后台Web管理系统" 区域 ************************************************************************/

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
