package com.workdatabase.Controller;


import com.workdatabase.domain.Voice;
import com.workdatabase.domain.donate;
import com.workdatabase.domain.donate_user;
import com.workdatabase.mapper.CertifiedMapper;
import com.workdatabase.mapper.DonateMapper;
import com.workdatabase.mapper.Donate_userMapper;
import com.workdatabase.mapper.UserMapper;
import com.workdatabase.resp.CommonResp;
import com.workdatabase.server.web.DonateService;
import com.workdatabase.server.web.Donate_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/donation")
public class DonateController {

    @Autowired
    private DonateMapper donateMapper;
    @Autowired
    private CertifiedMapper certifiedMapper;

    @Autowired
    private DonateService donateService;

    @Autowired
    private Donate_userMapper donate_userMapper;

    @Autowired
    private Donate_userService donate_userService;

    @GetMapping("/test")
    public donate_user  test(@RequestParam Integer donate_id,@RequestParam String openid,@RequestParam Integer push){
        return donate_userMapper.Select(donate_id,openid);
    }


    @GetMapping("/donate")       //捐款操作
    public CommonResp donation(@RequestParam String openid, @RequestParam Integer push_Money, @RequestParam Integer id){

        CommonResp<String> commonResp = new CommonResp();
        String user_id = openid;
        if(push_Money > 0){
            Integer current_Money = certifiedMapper.SelectById_Money(user_id);
            if(push_Money<=current_Money){              //可以成功捐款，需要改变数据库数据
                current_Money -= push_Money;
                donate m =  donateMapper.SelectById(id);
                Integer update_current = m.getHad();        //1.获取当前进度
                Integer need_Money = m.getNeed()-m.getHad();
                if(need_Money>=push_Money){
                    update_current += push_Money;
                    donateMapper.Update(id,update_current);                //更新捐款数据
                    certifiedMapper.Update_Money(user_id,current_Money);      ////更新用户拥有的积分
                    commonResp.setContent("");
                    commonResp.setSuccess(true);
                    commonResp.setMessage("捐款成功");
                    donate_userService.Update(id,openid,push_Money);
                }
                else {
                    update_current += need_Money;
                    donateMapper.Update(id,update_current);                //更新捐款数据
                    current_Money += (push_Money - need_Money);
                    certifiedMapper.Update_Money(user_id,current_Money);     //更新用户拥有的积分
                    commonResp.setContent("");
                    commonResp.setSuccess(true);
                    commonResp.setMessage("捐款成功,超额返回您：" + (push_Money - need_Money) + "元");
                    donate_userService.Update(id,openid,need_Money);
                }
            }
            else {
                commonResp.setContent("");
                commonResp.setSuccess(false);
                commonResp.setMessage("捐款失败");
            }
        }
        else{
            commonResp.setContent("");
            commonResp.setSuccess(false);
            commonResp.setMessage("不能输入小于等于0的数!");
        }
        return commonResp;
    }

    @GetMapping("/fresh")                   //2.用分页的方式，返回当前捐款信息
    public CommonResp fresh(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String name){
        return page(pageNum,pageSize,name);
    }

    @GetMapping("/object")
    public CommonResp object(@RequestParam Integer donate_id,@RequestParam String openid){
        donate data = donateService.getById(donate_id);      //展示项目具体信息

        List<donate> data_to_change = new ArrayList<donate>();
        data_to_change.add(data);
        List<Double> prog = donateService.change(data_to_change);         //计算项目当前进度
        System.out.println(prog);

        Integer flag = donate_userMapper.Select_Exit(donate_id,openid);
        Integer ever_push = 0;
        if(flag == 0 ){     //没对此项目捐过款
            ever_push = 0;
        }
        else {              //曾经捐款
            ever_push = donate_userMapper.Select_Push(donate_id,openid);
        }

        Map<String,Object> res = new HashMap<>();
        res.put("data",data);
        res.put("prog",prog);
        res.put("ever_push",ever_push);
        CommonResp< Map<String,Object> > commonResp = new CommonResp();
        commonResp.setContent(res);
        commonResp.setSuccess(true);
        commonResp.setMessage("当前项目数据如下。");
        return commonResp;
    }
    /*************************************   "后台Web管理系统"区域  ************************************************************************/
    //1.用分页的方式，返回当前捐款对象信息
    @GetMapping("/page")
    public CommonResp page(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam String  name){
        pageNum=(pageNum-1)*pageSize;
        name = "%"+name+"%";
        Map<String,Object> res = new HashMap<>();
        List<donate> data = donateMapper.SelectPage(pageNum,pageSize,name);

        List<Double> prog = donateService.change(data);         //计算项目当前进度
//        System.out.println(prog);

        Integer total = donateMapper.SelectCount(name);
        res.put("data" , data);
        res.put("prog",prog);
        res.put("total" , total);
        CommonResp< Map<String,Object> > commonResp = new CommonResp();
        commonResp.setContent(res);
        commonResp.setSuccess(true);
        commonResp.setMessage("查找成功。");
        return commonResp;
    }
    //2.新增或者修改
    @PostMapping("/save")
    public CommonResp save(@RequestBody donate donate){
        boolean flag = donateService.saveOrUpdate(donate);
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
    public CommonResp delete(@RequestBody donate donate){
        Integer flag = donateMapper.DeleteById(donate.getId());
        CommonResp< List<donate> > commonResp = new CommonResp();
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
