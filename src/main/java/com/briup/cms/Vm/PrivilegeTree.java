package com.briup.cms.Vm;

import com.briup.cms.bean.BasePrivilege;

import java.util.List;

public class PrivilegeTree extends BasePrivilege {
    private List<BasePrivilege> children;

    public List<BasePrivilege> getChildren() {
        return children;
    }

    public void setChildren(List<BasePrivilege> children) {
        this.children = children;
    }
}
