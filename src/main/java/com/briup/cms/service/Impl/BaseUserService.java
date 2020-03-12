package com.briup.cms.service.Impl;

import com.briup.cms.Vm.UserVM;
import com.briup.cms.bean.BaseUser;
import com.briup.cms.bean.BaseUserExample;
import com.briup.cms.bean.BaseUserRole;
import com.briup.cms.bean.BaseUserRoleExample;
import com.briup.cms.bean.extend.BaseUserExtend;
import com.briup.cms.dao.BaseUserMapper;
import com.briup.cms.dao.BaseUserRoleMapper;
import com.briup.cms.dao.extend.BaseUserExtendMapper;
import com.briup.cms.service.IBaseUserService;
import com.briup.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class BaseUserService implements IBaseUserService {
    @Resource
    BaseUserExtendMapper baseUserExtendMapper ;
    @Resource
    BaseUserRoleMapper baseUserRoleMapper;
    @Resource
    BaseUserMapper baseUserMapper;
    @Override
    public BaseUser login(UserVM userVM) throws CustomerException {
        BaseUserExample example = new BaseUserExample();
        example.createCriteria().andUsernameEqualTo(userVM.getUsername());
        List<BaseUser> list = baseUserMapper.selectByExample(example);
        if(list.size()<=0){
            throw new CustomerException("该用户不存在");
        }
        BaseUser user = list.get(0);
        if(!user.getPassword().equals(userVM.getPassword())){
            throw new CustomerException("密码不匹配");
        }
        return user;

    }

    //通过id查询用户信息包含角色信息
    @Override
    public BaseUserExtend findById(Long id) {
        BaseUserExtend baseUserExtend = baseUserExtendMapper.selectById(id);
        return baseUserExtend;
    }

    @Override
    public List<BaseUser> findAll() {
        return baseUserMapper.selectByExample(new BaseUserExample());
    }

    @Override
    public List<BaseUserExtend> cascadeRoleFindAll() {
        return baseUserExtendMapper.selectAll();
    }

    @Override
    public void saveOrUpdate(BaseUser baseUser) throws CustomerException {
        if(baseUser.getId()!=null){
            baseUserMapper.updateByPrimaryKey(baseUser);
        } else {
            // 判断用户名是否被占用
            BaseUserExample example = new BaseUserExample();
            example.createCriteria().andUsernameEqualTo(baseUser.getUsername());
            List<BaseUser> list = baseUserMapper.selectByExample(example);
            if(list.size()>0){
                throw new CustomerException("该用户已经被占用");
            }
            // 初始化
            baseUser.setRegisterTime(new Date().getTime());
            baseUser.setStatus(BaseUserExtend.STATUS_NORMAL);
            baseUserMapper.insert(baseUser);
        }
    }

    @Override
    public void changeStatus(long id,String status) throws CustomerException {
        BaseUser user = this.findById(id);
        if(user==null){
            throw new CustomerException("该用户不存在");
        }
        user.setStatus(status);
        baseUserMapper.updateByPrimaryKey(user);
    }

    //设置用户角色信息
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
