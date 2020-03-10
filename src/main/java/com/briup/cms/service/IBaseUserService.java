package com.briup.cms.service;

import com.briup.cms.bean.extend.BaseUserExtend;

import java.util.List;

public interface IBaseUserService {
    BaseUserExtend findById(Long id);

    void setRoles(Long id, List<Long> roles);


}
