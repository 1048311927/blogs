package com.briup.cms.bean.extend;

import com.briup.cms.bean.BasePrivilege;
import com.briup.cms.bean.BaseRole;


import java.util.List;

public class BaseRoleExtend extends BaseRole {
    private List<BasePrivilege> privileges;


    public List<BasePrivilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<BasePrivilege> privileges) {
        this.privileges = privileges;
    }
}
