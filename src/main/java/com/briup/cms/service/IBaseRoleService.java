package com.briup.cms.service;

import com.briup.cms.bean.BaseRole;
import com.briup.cms.bean.extend.BaseRoleExtend;
import com.briup.cms.utils.CustomerException;

import java.util.List;

public interface IBaseRoleService {
    void authorization(Long roleId,List<Long> privilegeIds);

    List<BaseRole> findAll();

    List<BaseRoleExtend> cascadePrivilegeFindAll();

    void deleteById(Long id) throws CustomerException;

    void saveOrUpdate(BaseRole role) throws CustomerException;
}
