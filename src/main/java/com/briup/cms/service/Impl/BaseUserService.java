package com.briup.cms.service.Impl;

import com.briup.cms.bean.BaseUserExample;
import com.briup.cms.bean.BaseUserRole;
import com.briup.cms.bean.BaseUserRoleExample;
import com.briup.cms.bean.extend.BaseUserExtend;
import com.briup.cms.dao.BaseUserRoleMapper;
import com.briup.cms.dao.extend.BaseUserExtendMapper;
import com.briup.cms.service.IBaseUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BaseUserService implements IBaseUserService {
    @Resource
    BaseUserExtendMapper baseUserExtendMapper ;
    @Resource
    BaseUserRoleMapper baseUserRoleMapper;
    @Override
    public BaseUserExtend findById(Long id) {
        BaseUserExtend baseUserExtend = baseUserExtendMapper.selectById(id);
        return baseUserExtend;
    }

    @Override
    public void setRoles(Long userId, List<Long> roles) {
        //通过UserId查询自己的角色
        BaseUserRoleExample baseUserExample = new BaseUserRoleExample();
        baseUserExample.createCriteria().andUserIdEqualTo(userId);
        List<BaseUserRole> list = baseUserRoleMapper.selectByExample(baseUserExample);
        //获得旧角色
        List<Long> oldRoles = new ArrayList<>();
        Iterator<BaseUserRole> iterator = list.iterator();
        while (iterator.hasNext()){
            oldRoles.add(iterator.next().getRoleId());
        }
        //依次判断新角色是否在存在于list集合中
        for (Long roleId : roles){
            if (!oldRoles.contains(roleId)){
                BaseUserRole baseUserRole = new BaseUserRole();
                baseUserRole.setUserId(userId);
                baseUserRole.setRoleId(roleId);
                baseUserRoleMapper.insert(baseUserRole);
            }
        }
        //依次判断老的角色是否存在于roles中,如果不存在则删除
        for (BaseUserRole userRole:list){
            if (!roles.contains(userRole.getRoleId())){
                baseUserRoleMapper.deleteByPrimaryKey(userRole.getId());
            }
        }
    }
}
