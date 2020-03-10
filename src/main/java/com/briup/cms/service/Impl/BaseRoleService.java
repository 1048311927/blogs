package com.briup.cms.service.Impl;

import com.briup.cms.bean.BaseRole;
import com.briup.cms.bean.BaseRoleExample;
import com.briup.cms.bean.BaseRolePrivilege;
import com.briup.cms.bean.BaseRolePrivilegeExample;
import com.briup.cms.bean.extend.BaseRoleExtend;
import com.briup.cms.dao.BaseRoleMapper;
import com.briup.cms.dao.BaseRolePrivilegeMapper;
import com.briup.cms.dao.extend.BaseRoleExtendMapper;
import com.briup.cms.service.IBaseRoleService;
import com.briup.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class BaseRoleService implements IBaseRoleService {

    @Resource
    private BaseRoleMapper baseRoleMapper;

    @Resource
    private BaseRoleExtendMapper baseRoleExtendMapper;

    @Resource
    BaseRolePrivilegeMapper baseRolePrivilegeMapper;
    @Override
    public void authorization(Long roleId, List<Long> privilegeIds) {
        //根据roleId查询出所有的权限
        BaseRolePrivilegeExample example = new BaseRolePrivilegeExample();
        example.createCriteria().andRoleIdEqualTo(roleId);

        List<BaseRolePrivilege> list = baseRolePrivilegeMapper.selectByExample(example);

        //将list转化为privilegeIDs的集合
        List<Long> old_privilegeIds = new ArrayList<>();
        for(BaseRolePrivilege rp : list){
            old_privilegeIds.add(rp.getPrivilegeId());
        }
        //依次判断privilegeIds 是否存在于 old_privilegeIds,如果不在 则插入

        for(Long privilegeId : privilegeIds){
            if(!old_privilegeIds.contains(privilegeId)){
                BaseRolePrivilege rp = new BaseRolePrivilege();
                rp.setRoleId(roleId);
                rp.setPrivilegeId(privilegeId);
                baseRolePrivilegeMapper.insert(rp);
            }
        }
        //依次判断 旧权限 是否 存在于 新权限中,如果不在则删除
        for(long privilegeId : old_privilegeIds){
            if (!privilegeIds.contains(privilegeId)){
                //根据privilegeId从桥表中删除
                example.clear();
                example.createCriteria().andRoleIdEqualTo(roleId).andPrivilegeIdEqualTo(privilegeId);
                baseRolePrivilegeMapper.deleteByExample(example);
            }

        }
     }

    @Override
    public List<BaseRole> findAll() {
        return baseRoleMapper.selectByExample(new BaseRoleExample());
    }

    @Override
    public List<BaseRoleExtend> cascadePrivilegeFindAll() {
        List<BaseRoleExtend> list = baseRoleExtendMapper.cascadePrivilegeFindAll();
        return list;
    }

    @Override
    public void deleteById(Long id) throws CustomerException {
        BaseRole role = baseRoleMapper.selectByPrimaryKey(id);
        if(role == null){
            throw new CustomerException("要删除的角色不存在");
        }
        baseRoleMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void saveOrUpdate(BaseRole baseRole) throws CustomerException {
        if(baseRole.getId()!=null){
            baseRoleMapper.updateByPrimaryKey(baseRole);
        } else {
            baseRoleMapper.insert(baseRole);
        }
    }
}
