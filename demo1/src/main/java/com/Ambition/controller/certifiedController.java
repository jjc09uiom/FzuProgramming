package com.Ambition.controller;

import com.Ambition.pojo.certified;
import com.Ambition.service.certifiedService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class certifiedController {
    @Resource
    private certifiedService certifiedService;

    @GetMapping("/classmate/search")
    public List<certified> searchClass(String openId) {
        List<certified> certifiedById = certifiedService.getCertifiedById(openId);
        return certifiedById;
    }
}
