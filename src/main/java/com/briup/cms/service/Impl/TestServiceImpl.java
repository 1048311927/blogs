package com.briup.cms.service.Impl;

import com.briup.cms.bean.Test;
import com.briup.cms.bean.TestExample;
import com.briup.cms.dao.TestMapper;
import com.briup.cms.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TestServiceImpl implements ITestService {
    @Resource
    private TestMapper testMapper;
    @Override
    public void saveOrUpdate(Test test) {
        if(test.getId() != null){
            testMapper.updateByPrimaryKey(test);
        }else {
            testMapper.insert(test);
        }
    }

    @Override
    public List<Test> findAll() {
        TestExample example = new TestExample();

        return testMapper.selectByExample(example);
    }
}
