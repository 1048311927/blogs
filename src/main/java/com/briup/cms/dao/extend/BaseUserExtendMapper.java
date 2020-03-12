package com.briup.cms.dao.extend;

import com.briup.cms.bean.extend.BaseUserExtend;

import java.util.List;

public interface BaseUserExtendMapper  {
    BaseUserExtend selectById(Long id);

    List<BaseUserExtend> selectAll();
}
