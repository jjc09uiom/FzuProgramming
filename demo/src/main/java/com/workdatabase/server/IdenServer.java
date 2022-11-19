package com.workdatabase.server;

import com.workdatabase.domain.Identify;
import com.workdatabase.domain.IdentifyExample;
import com.workdatabase.exception.BusinessException;
import com.workdatabase.exception.BusinessExceptionCode;
import com.workdatabase.mapper.IdentifyMapper;
import com.workdatabase.req.IdentifyQueryReq;
import com.workdatabase.req.IdentifySaveReq;
import com.workdatabase.resp.IdentifyResp;
import com.workdatabase.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IdenServer {
    private static final Logger LOG = LoggerFactory.getLogger(IdenServer.class);

    @Resource
    private IdentifyMapper identifyMapper;

    public Identify selectByPrimaryKeyLoginName(String loginName){
        IdentifyExample identifyExample=new IdentifyExample();
        IdentifyExample.Criteria criteria=identifyExample.createCriteria();
        criteria.andNameLike(loginName);
        List<Identify> list=identifyMapper.selectByExample(identifyExample);
        if(ObjectUtils.isEmpty(list)){
            Identify identify=new Identify();
            identify.setName("无");
            identify.setRoommatename(" ");
            identify.setPhonenumber(" ");
            identify.setAcademyname(" ");
            identify.setBanji(0);
            identify.setDepartment(" ");
            return identify;
        }else {
            return list.get(0);
        }
    }



    public IdentifyResp identify(IdentifyQueryReq req){
        Identify InfDB=selectByPrimaryKeyLoginName(req.getName());
        IdentifyResp identifyResp=CopyUtil.copy(InfDB,IdentifyResp.class);
        if(InfDB.getName().equals("无")){
            //用户不存在
            LOG.info("用户不存在:{}",req.getName());
            identifyResp.setFlag(false);
            return identifyResp;
        }else{
            String [] team=InfDB.getRoommatename().split(",");
            int flag=0;
            for(int i=0;i<team.length;i++){
                if(team[i].equals(req.getRoommatename())){
                    flag=1;
                    InfDB.setRoommatename(team[i]);
                    break;
                }
            }
            if(flag==1){
                //登录成功
                identifyResp.setFlag(true);
                LOG.info("{}登陆成功,舍友名为：{}",req.getName(),InfDB.getRoommatename());
                return identifyResp;
            }else {
                identifyResp.setFlag(false);
                LOG.info("认证失败,输入的舍友名：{},数据库的舍友名：{}",req.getRoommatename(),InfDB.getRoommatename());
                return identifyResp;
            }
        }

    }

    public void insert(IdentifySaveReq req){
        Identify DB=selectByPrimaryKeyLoginName(req.getName());
        if(ObjectUtils.isEmpty(DB)){
            //查询数据库中没有此人
            Identify identify=CopyUtil.copy(req,Identify.class);
            identifyMapper.insert(identify);
        }else {
            //数据库中已经有此人
            throw new BusinessException(BusinessExceptionCode.USER_LOGIN_NAME_EXIST);
        }
    }

    public void delete(String name){
        identifyMapper.deleteByPrimaryKey(name);
    }


}
