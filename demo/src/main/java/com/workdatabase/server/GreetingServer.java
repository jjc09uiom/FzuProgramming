package com.workdatabase.server;

import com.workdatabase.domain.Voice;
import com.workdatabase.mapper.VoiceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GreetingServer {

    @Resource
    private VoiceMapper voiceMapper;

    public List<Voice> list(){
        return voiceMapper.list();
    }

}
