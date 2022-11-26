package com.workdatabase.Controller;

import com.workdatabase.domain.Certified;
import com.workdatabase.domain.Voice;
import com.workdatabase.mapper.CertifiedMapper;
import com.workdatabase.resp.CommonResp;
import com.workdatabase.server.web.CertifiedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certified")
public class CertifiedController {

    @Autowired
    private CertifiedService certifiedService;
    @Autowired
    private CertifiedMapper certifiedMapper;
    /*************************************   "后台Web管理系统"区域  ************************************************************************/
    //1.用分页的方式，返回当前捐款信息
    @GetMapping("/fresh")
    public CommonResp fresh(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        CommonResp<List<Certified>> commonResp = new CommonResp();
        pageNum = (pageNum - 1)* pageSize;
        commonResp.setContent(certifiedMapper.Select_ByPage(pageNum,pageSize));
        commonResp.setSuccess(true);
        commonResp.setMessage("请求数据成功");
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
        Integer flag = certifiedMapper.DeleteById(certified.getOpenid());
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

}
