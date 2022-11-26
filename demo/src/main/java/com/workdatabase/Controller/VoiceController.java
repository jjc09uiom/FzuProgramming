package com.workdatabase.Controller;


import com.workdatabase.domain.Voice;
import com.workdatabase.mapper.VoiceMapper;
import com.workdatabase.resp.CommonResp;
import com.workdatabase.server.web.VoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voice")
public class VoiceController {

    @Autowired
    private VoiceMapper voiceMapper;

    @Autowired
    private VoiceService voiceService;
/*************************************   "后台Web管理系统"区域  ************************************************************************/
    //1.用分页的方式，返回当前捐款信息
    @GetMapping("/fresh")
    public CommonResp fresh(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        CommonResp< List<Voice> > commonResp = new CommonResp();
        pageNum = (pageNum - 1)* pageSize;
        commonResp.setContent(voiceMapper.Select_ByPage(pageNum,pageSize));
        commonResp.setSuccess(true);
        commonResp.setMessage("请求数据成功");
        return commonResp;
    }
    //2.新增或者修改
    @PostMapping("/save")
    public CommonResp save(@RequestBody Voice voice){
        boolean flag = voiceService.saveOrUpdate(voice);
        CommonResp< List<Voice> > commonResp = new CommonResp();
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
    public CommonResp delete(@RequestBody Voice voice){
        Integer flag = voiceMapper.DeleteById(voice.getKeyId());
        CommonResp< List<Voice> > commonResp = new CommonResp();
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

}
