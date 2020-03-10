package com.briup.cms.service;

import com.briup.cms.bean.Test;

import java.util.List;

public interface ITestService {
    public void saveOrUpdate(Test test);
    List<Test> findAll();
}
