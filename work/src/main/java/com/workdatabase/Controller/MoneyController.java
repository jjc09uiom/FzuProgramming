package com.workdatabase.Controller;


import com.workdatabase.domain.money;
import com.workdatabase.mapper.MoneyMapper;
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
public class MoneyController {

    @Autowired
    private MoneyMapper moneyMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/money")       //捐款操作
    public CommonResp donation(@RequestParam Integer openid, @RequestParam Integer push_Money, @RequestParam Integer id){
        CommonResp<String> commonResp = new CommonResp();
        Integer user_id = openid;
        if(push_Money > 0){
            Integer current_Money = userMapper.SelectById_integral(user_id);
            if(push_Money<=current_Money){
                current_Money -= push_Money;
                money m =  moneyMapper.SelectById(id);
                Integer update_current = m.getCurrent();        //1.获取当前进度
                Integer need_Money = m.getTarget() - m.getCurrent();
                if(need_Money>=push_Money){
                    update_current += push_Money;
                    moneyMapper.Update(id,update_current);                //更新捐款数据
                    userMapper.Update_integral(user_id,current_Money);      ////更新用户拥有的积分
                    commonResp.setContent("");
                    commonResp.setSuccess(true);
                    commonResp.setMessage("捐款成功");
//                    return "Success!";
                }
                else {
                    update_current += need_Money;
                    moneyMapper.Update(id,update_current);                //更新捐款数据
                    current_Money += (push_Money - need_Money);
                    userMapper.Update_integral(user_id,current_Money);     //更新用户拥有的积分
                    commonResp.setContent("");
                    commonResp.setSuccess(true);
                    commonResp.setMessage("捐款成功,超额返回您：" + (push_Money - need_Money) + "元");
//                    return "Success! 超额返回您：" + (push_Money - need_Money) + "元";
                }
            }
            else {
                commonResp.setContent("");
                commonResp.setSuccess(false);
                commonResp.setMessage("捐款失败");
//                return "Failed!";
            }
        }
        else{
            commonResp.setContent("");
            commonResp.setSuccess(false);
            commonResp.setMessage("不能输入小于等于0的数!");
//            return "不能输入小于等于0的数!";
        }
        return commonResp;
    }

    @GetMapping("/fresh")                   //2.用分页的方式，返回当前捐款信息
    public CommonResp fresh(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        CommonResp< List<money> > commonResp = new CommonResp();
        pageNum = (pageNum - 1)* pageSize;
        commonResp.setContent(moneyMapper.Select_All(pageNum,pageSize));
        commonResp.setSuccess(true);
        commonResp.setMessage("请求数据成功");
        return commonResp;
    }


}
