package com.briup.cms.bean.extend;

import com.briup.cms.bean.BaseRole;
import com.briup.cms.bean.BaseUser;

import java.util.List;

public class BaseUserExtend extends BaseUser {
    private List<BaseRole> roles;

    public List<BaseRole> getRoles() {
        return roles;
    }

    public void setRoles(List<BaseRole> roles) {
        this.roles = roles;
    }
}
