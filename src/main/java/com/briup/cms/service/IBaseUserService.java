package com.briup.cms.service;

import com.briup.cms.Vm.UserVM;
import com.briup.cms.bean.BaseUser;
import com.briup.cms.bean.extend.BaseUserExtend;
import com.briup.cms.utils.CustomerException;

import java.util.List;

public interface IBaseUserService {
    BaseUserExtend findById(Long id);

    void setRoles(Long id, List<Long> roles);

    public List<BaseUser> findAll();

    public List<BaseUserExtend> cascadeRoleFindAll();

    public void saveOrUpdate(BaseUser baseUser) throws CustomerException;

    public void changeStatus(long id,String status) throws CustomerException;

    public BaseUser login(UserVM userVM) throws CustomerException;
}
