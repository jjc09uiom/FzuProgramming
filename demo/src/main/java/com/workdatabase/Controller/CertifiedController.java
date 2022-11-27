package com.workdatabase.Controller;

import com.workdatabase.domain.Certified;
import com.workdatabase.domain.Voice;
import com.workdatabase.mapper.CertifiedMapper;
import com.workdatabase.resp.CommonResp;
import com.workdatabase.server.web.CertifiedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/certified")
public class CertifiedController {

    @Autowired
    private CertifiedService certifiedService;
    @Autowired
    private CertifiedMapper certifiedMapper;
    /*************************************   "后台Web管理系统"区域  ************************************************************************/
    //1.用分页的方式，返回当前用户信息
    @GetMapping("/page")
    public CommonResp page(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam String  name,
                                   @RequestParam String roommateName,
                                   @RequestParam String phonenumber,
                                   @RequestParam String graduationTime,
                                   @RequestParam String major,
                                   @RequestParam String banji,
                                   @RequestParam String department
                                   ){
        pageNum=(pageNum-1)*pageSize;
        name = "%"+name+"%";
        roommateName = "%"+roommateName+"%";
        phonenumber = "%"+phonenumber+"%";
        graduationTime = "%"+graduationTime+"%";
        major = "%"+major+"%";
        banji = "%"+banji+"%";
        department = "%" + department + "%";

        Map<String,Object> res = new HashMap<>();
        List<Certified> data = certifiedMapper.SelectPage(pageNum,pageSize,name,roommateName,phonenumber,graduationTime,major,banji,department);
        Integer total = certifiedMapper.SelectCount(name,roommateName,phonenumber,graduationTime,major,banji,department);
        res.put("data" , data);
        res.put("total" , total);

        CommonResp< Map<String,Object> > commonResp = new CommonResp();
        commonResp.setContent(res);
        commonResp.setSuccess(true);
        commonResp.setMessage("查找成功。");
        return commonResp;
    }
    //2.新增或者修改
    @PostMapping("/save")
    public CommonResp save(@RequestBody Certified certified){
        boolean flag = certifiedService.saveOrUpdate(certified);
        CommonResp< List<Certified> > commonResp = new CommonResp();
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
    @PostMapping("/delete")
    public CommonResp delete(@RequestBody Certified certified){
        Integer flag = certifiedMapper.DeleteByName(certified.getName());
        CommonResp< List<Certified> > commonResp = new CommonResp();
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
    /*************************************   "后台Web管理系统"区域  ************************************************************************/


}
