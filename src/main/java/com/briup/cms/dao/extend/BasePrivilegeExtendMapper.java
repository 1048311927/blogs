package com.briup.cms.dao.extend;

import com.briup.cms.Vm.PrivilegeTree;
import com.briup.cms.bean.BasePrivilege;
import com.briup.cms.bean.BasePrivilegeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasePrivilegeExtendMapper {

    List<PrivilegeTree> selectAll();

    List<PrivilegeTree> selectByParentId(Long id);

    List<PrivilegeTree> selectByRoleId(Long id);
}