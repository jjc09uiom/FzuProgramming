package com.workdatabase.server.web;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.workdatabase.domain.Voice;
import com.workdatabase.mapper.MybatisPlus.VoiceMapperPlus;
import org.springframework.stereotype.Service;

@Service
public class VoiceService extends ServiceImpl<VoiceMapperPlus, Voice> {

}
