package com.workdatabase.server.web;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.workdatabase.domain.Certified;
import com.workdatabase.mapper.MybatisPlus.CertifiedMapperPlus;
import org.springframework.stereotype.Service;

@Service
public class CertifiedService extends ServiceImpl<CertifiedMapperPlus, Certified> {

}
