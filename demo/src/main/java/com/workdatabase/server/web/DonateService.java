package com.workdatabase.server.web;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.workdatabase.domain.donate;
import com.workdatabase.mapper.MybatisPlus.DonateMapperPlus;
import org.springframework.stereotype.Service;

@Service
public class DonateService extends ServiceImpl<DonateMapperPlus, donate> {
}
