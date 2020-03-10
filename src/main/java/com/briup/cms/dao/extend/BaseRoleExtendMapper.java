package com.briup.cms.dao.extend;

import com.briup.cms.bean.BaseRole;
import com.briup.cms.bean.extend.BaseRoleExtend;

import java.util.List;

public interface BaseRoleExtendMapper {
    List<BaseRole> selectByUserId(Long id);

    List<BaseRoleExtend> cascadePrivilegeFindAll();
}
