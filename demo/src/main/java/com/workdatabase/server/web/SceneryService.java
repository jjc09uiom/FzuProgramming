package com.workdatabase.server.web;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.workdatabase.domain.Scenery;
import com.workdatabase.mapper.MybatisPlus.SceneryMapperPlus;
import org.springframework.stereotype.Service;

@Service
public class SceneryService extends ServiceImpl<SceneryMapperPlus, Scenery> {
}
