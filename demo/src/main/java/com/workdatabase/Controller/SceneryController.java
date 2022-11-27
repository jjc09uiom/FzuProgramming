//package com.workdatabase.Controller;
//
//import com.workdatabase.domain.Scenery;
//import com.workdatabase.domain.Voice;
//import com.workdatabase.mapper.SceneryMapper;
//import com.workdatabase.resp.CommonResp;
//import com.workdatabase.server.web.SceneryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/scenery")
//public class SceneryController {
//
//    @Autowired
//    private SceneryMapper sceneryMapper;
//    @Autowired
//    private SceneryService sceneryService;
//
///*************************************   "后台Web管理系统"区域  ************************************************************************/
//    //1.用分页的方式，返回当前景点信息
//    @GetMapping("/page")
//    public CommonResp page(@RequestParam Integer pageNum,
//                           @RequestParam Integer pageSize,
//                           @RequestParam String  sname){
//        pageNum=(pageNum-1)*pageSize;
//        sname = "%"+sname+"%";
//        Map<String,Object> res = new HashMap<>();
//        List<Scenery> data = sceneryMapper.SelectPage(pageNum,pageSize,sname);
//        Integer total = sceneryMapper.SelectCount(sname);
//        res.put("data" , data);
//        res.put("total" , total);
//        CommonResp< Map<String,Object> > commonResp = new CommonResp();
//        commonResp.setContent(res);
//        commonResp.setSuccess(true);
//        commonResp.setMessage("查找成功。");
//        return commonResp;
//    }
//    //2.新增或者修改
//    @PostMapping("/save")
//    public CommonResp save(@RequestBody Scenery scenery){
//        boolean flag = sceneryService.saveOrUpdate(scenery);
//        CommonResp< List<Voice> > commonResp = new CommonResp();
//        if(flag){
//            commonResp.setContent(null);
//            commonResp.setSuccess(true);
//            commonResp.setMessage("新增或者修改成功。");
//        }
//        else {
//            commonResp.setContent(null);
//            commonResp.setSuccess(false);
//            commonResp.setMessage("新增或者修改失败。");
//        }
//        return commonResp;
//    }
//    //3.删除
//    @PostMapping("/delete")
//    public CommonResp delete(@RequestBody Scenery scenery){
//        Integer flag = sceneryMapper.DeleteByName(scenery.getSname());
//        CommonResp< List<Scenery> > commonResp = new CommonResp();
//        if(flag > 0) {
//            commonResp.setContent(null);
//            commonResp.setSuccess(true);
//            commonResp.setMessage("删除成功。");
//        }
//        else {
//            commonResp.setContent(null);
//            commonResp.setSuccess(false);
//            commonResp.setMessage("删除失败。");
//        }
//        return commonResp;
//    }
//
///*************************************   "后台Web管理系统" 区域 ************************************************************************/
//
//}
