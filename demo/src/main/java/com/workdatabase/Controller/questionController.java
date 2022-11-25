package com.workdatabase.Controller;


import com.workdatabase.domain.Inter_Static;
import com.workdatabase.domain.Inter_record;
import com.workdatabase.server.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

}
