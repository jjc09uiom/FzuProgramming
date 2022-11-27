package com.workdatabase.server.web;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.workdatabase.domain.TheMap;
import com.workdatabase.mapper.MybatisPlus.TheMapMapperPlus;
import org.springframework.stereotype.Service;

@Service
public class SceneryService extends ServiceImpl<TheMapMapperPlus, TheMap> {
}
