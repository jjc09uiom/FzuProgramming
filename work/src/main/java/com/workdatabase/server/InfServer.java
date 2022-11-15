package com.workdatabase.server;

import com.workdatabase.domain.Information;
import com.workdatabase.domain.InformationExample;
import com.workdatabase.exception.BusinessException;
import com.workdatabase.exception.BusinessExceptionCode;
import com.workdatabase.mapper.InformationMapper;
import com.workdatabase.req.InformationQueryReq;
import com.workdatabase.resp.InfidentifyResp;
import com.workdatabase.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InfServer {
    private static final Logger LOG = LoggerFactory.getLogger(InfServer.class);

    @Resource
    private InformationMapper InfMapper;

    public Information selectByPrimaryKeyLoginName(String loginName){
        InformationExample informationExample=new InformationExample();
        InformationExample.Criteria criteria=informationExample.createCriteria();
        criteria.andNameLike(loginName);
        List<Information> list=InfMapper.selectByExample(informationExample);
        if(ObjectUtils.isEmpty(list)){
            return null;
        }else {
            return list.get(0);
        }
    }

    public InfidentifyResp identify(InformationQueryReq req){
        Information InfDB=selectByPrimaryKeyLoginName(req.getName());
        if(ObjectUtils.isEmpty(InfDB)){
            //用户不存在
            LOG.info("用户不存在,{}",req.getName());
            throw  new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
        }else{
            String [] team=InfDB.getColleageName().split(",");
            int flag=0;
            for(int i=0;i<team.length;i++){
                if(team[i].equals(req.getColleageName())){
                    flag=1;
                    InfDB.setColleageName(team[i]);
                    break;
                }
            }
            if(flag==1){
                //登录成功
                InfidentifyResp infidentifyResp= CopyUtil.copy(InfDB,InfidentifyResp.class);
                return infidentifyResp;
            }else {
                LOG.info("认证失败,输入的舍友名：{},数据库的舍友名：{}",req.getColleageName(),InfDB.getColleageName());
                throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
            }
        }

    }


}
