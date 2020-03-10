package com.briup.cms.web.controller;

import com.briup.cms.bean.Test;
import com.briup.cms.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    这是一个测试类
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ITestService testService;
//    pulic List<Map<String,String>>  findAll(){
//        return null;
//    }
    @GetMapping("findAll")
    public List<Test> findAll(){

        return testService.findAll();
    }
    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(Test test){
        testService.saveOrUpdate(test);
        return "保存成功";
    }
}
