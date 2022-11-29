package com.workdatabase.server.web;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.workdatabase.domain.question;
import com.workdatabase.mapper.MybatisPlus.QuestionMapperPlus;
import org.springframework.stereotype.Service;

@Service
public class QuestionService_Plus extends ServiceImpl<QuestionMapperPlus, question> {
}
