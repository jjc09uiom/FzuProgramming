package com.workdatabase.Controller;


import com.workdatabase.domain.Inter_Static;
import com.workdatabase.domain.Inter_record;
import com.workdatabase.domain.question;
import com.workdatabase.mapper.QuestionMapper;
import com.workdatabase.resp.CommonResp;
import com.workdatabase.server.QuestionService;
import com.workdatabase.server.web.QuestionService_Plus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class questionController {

    @GetMapping("/Weixin/getListOfAnswer")
    public List<Inter_Static> getListOfAnswer(){
        List<Inter_Static> list1=new ArrayList<>();
        QuestionService service = new QuestionService();
        List<QuestionService.inter_Static> list=service.get_Inter_Static();
        for(int i=0;i<list.size();i++){
           Inter_Static inter_static=new Inter_Static();
           inter_static.setName(list.get(i).name);
           inter_static.setGra_time(list.get(i).gra_time);
           inter_static.setTotal_inter(list.get(i).total_inter);
           inter_static.setMajor(list.get(i).major);
           list1.add(inter_static);
        }
        return list1;

    }

    @PostMapping("/Weixin/getUserRecord")
    public List<Inter_record> getRecord(String id){
        List<Inter_record> list1=new ArrayList<>();
        QuestionService service = new QuestionService();
        List<QuestionService.inter_Record> list=service.get_Inter_Record(id);
        for(int i=0;i<list.size();i++){
            Inter_record inter_record = new Inter_record();
            inter_record.setGain(list.get(i).gain);
            inter_record.setTime(list.get(i).time);
            list1.add(inter_record);
        }
        return list1;
    }

    @PostMapping("/Weixin/insertNewRecord")
    public void insert_Record(String id,int score){
        QuestionService service=new QuestionService();
        service.insert_Record(id,score);
    }

    @PostMapping("/Weixin/getQuestion")
    public List<QuestionService.q_Saver> getQuestion(int num){
        QuestionService service=new QuestionService();
        List<QuestionService.q_Saver> list=service.get_Question(num);
        return list;
    }
    /*************************************   "后台Web管理系统"区域  ************************************************************************/
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionService_Plus questionService_plus;

    //1.用分页的方式，返回当前题库信息
    @GetMapping("/question/page")
    public CommonResp page(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam String  question){
        pageNum=(pageNum-1)*pageSize;
        question = "%"+question+"%";
        Map<String,Object> res = new HashMap<>();
        List<question> data = questionMapper.SelectPage(pageNum,pageSize,question);
        Integer total = questionMapper.SelectCount(question);
        res.put("data" , data);
        res.put("total" , total);
        CommonResp< Map<String,Object> > commonResp = new CommonResp();
        commonResp.setContent(res);
        commonResp.setSuccess(true);
        commonResp.setMessage("查找成功。");
        return commonResp;
    }
    //2.新增或者修改
    @PostMapping("/question/save")
    public CommonResp save(@RequestBody question question){
        boolean flag = questionService_plus.saveOrUpdate(question);
        CommonResp< List<question> > commonResp = new CommonResp();
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
    @PostMapping("/question/delete")
    public CommonResp delete(@RequestBody question question){
        Integer flag = questionMapper.DeleteById(question.getKeyId());
        CommonResp< List<question> > commonResp = new CommonResp();
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
