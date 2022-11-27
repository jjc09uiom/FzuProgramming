package com.workdatabase.Controller;


import com.workdatabase.domain.donate;
import com.workdatabase.mapper.CertifiedMapper;
import com.workdatabase.mapper.DonateMapper;
import com.workdatabase.mapper.UserMapper;
import com.workdatabase.resp.CommonResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/donation")
public class DonateController {

    @Autowired
    private DonateMapper donateMapper;
    @Autowired
    private CertifiedMapper certifiedMapper;

    @GetMapping("/donate")       //捐款操作
    public CommonResp donation(@RequestParam String openid, @RequestParam Integer push_Money, @RequestParam Integer id){
        CommonResp<String> commonResp = new CommonResp();
        String user_id = openid;
        if(push_Money > 0){
            Integer current_Money = certifiedMapper.SelectById_Money(user_id);
            if(push_Money<=current_Money){
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
                }
                else {
                    update_current += need_Money;
                    donateMapper.Update(id,update_current);                //更新捐款数据
                    current_Money += (push_Money - need_Money);
                    certifiedMapper.Update_Money(user_id,current_Money);     //更新用户拥有的积分
                    commonResp.setContent("");
                    commonResp.setSuccess(true);
                    commonResp.setMessage("捐款成功,超额返回您：" + (push_Money - need_Money) + "元");
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
        CommonResp< List<donate> > commonResp = new CommonResp();
        pageNum = (pageNum - 1)* pageSize;
        name = "%" + name + "%";
        commonResp.setContent(donateMapper.SelectPage(pageNum,pageSize,name));
        commonResp.setSuccess(true);
        commonResp.setMessage("请求数据成功");
        return commonResp;
    }


}
