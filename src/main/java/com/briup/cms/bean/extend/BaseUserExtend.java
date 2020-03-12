package com.briup.cms.bean.extend;

import com.briup.cms.bean.BaseRole;
import com.briup.cms.bean.BaseUser;

import java.util.List;

public class BaseUserExtend extends BaseUser {
    public static final String STATUS_NORMAL="正常";
    public static final String STATUS_FORBIDDEN="禁用";

    private List<BaseRole> roles;

    public List<BaseRole> getRoles() {
        return roles;
    }

    public void setRoles(List<BaseRole> roles) {
        this.roles = roles;
    }
}
