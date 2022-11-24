package com.workdatabase.server;

import com.workdatabase.domain.HashPoint;
import com.workdatabase.domain.HashPointExample;
import com.workdatabase.domain.TheMap;
import com.workdatabase.domain.Voice;
import com.workdatabase.mapper.HashPointMapper;
import com.workdatabase.mapper.TheMapMapper;
import com.workdatabase.mapper.VoiceMapper;
import com.workdatabase.resp.HashPointResp;
import com.workdatabase.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TheMapServer {

    @Resource
    private TheMapMapper theMapMapper;

    @Resource
    private HashPointMapper hashPointMapper;

    @Resource
    private VoiceMapper voiceMapper;


    public List<TheMap> list(){
       return theMapMapper.list();
    }

    public void addMessage(HashPoint req){
        hashPointMapper.insert(req);

    }

    public List<HashPoint> selectById(int id){
        HashPointExample hashPointExample=new HashPointExample();
        HashPointExample.Criteria criteria=hashPointExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<HashPoint> list=hashPointMapper.selectByExample(hashPointExample);
        if(ObjectUtils.isEmpty(list)){
            return null;
        }else {
            return list;
        }

    }

    public List<HashPointResp> findById(int id){

        List<HashPoint> HashDB=selectById(id);

        List<HashPointResp> list= CopyUtil.copyList(HashDB,HashPointResp.class);
        for (int i = 0; i < list.size(); i++) {
            Voice voice=voiceMapper.selectByPrimaryKey(list.get(i).getKeyid());
            list.get(i).setGreeting(voice.getGreeting());
        }


        return list;

    }

}
