package com.Ambition.service;

import com.Ambition.pojo.certified;

import java.util.List;

public interface certifiedService {
    List<certified> getCertifiedById(String openId);
}
