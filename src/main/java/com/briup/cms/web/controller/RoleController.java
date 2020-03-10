package com.briup.cms.web.controller;


import com.briup.cms.bean.BaseRole;
import com.briup.cms.bean.extend.BaseRoleExtend;
import com.briup.cms.service.IBaseRoleService;
import com.briup.cms.utils.Message;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/role")
@RestController
@Validated
public class RoleController {
    @Autowired
    private IBaseRoleService baseRoleService;

    @GetMapping("findAll")
    @ApiOperation(value = "查询所有")
    public Message<List<BaseRole>> findAll(){
        List<BaseRole> baseRoles = baseRoleService.findAll();
        return Message.success(baseRoles);
    }


    @GetMapping("cascadePrivilegeFindAll")
    @ApiOperation(value = "查询所有",notes = "级联查询")
    public Message<List<BaseRoleExtend>> cascadePrivilegeFindAll(){
        List<BaseRoleExtend> baseRoleExtends = baseRoleService.cascadePrivilegeFindAll();
        return Message.success(baseRoleExtends);
    }

    @GetMapping("deleteById")
    @ApiOperation("通过roleId来删除")
    public Message<String> deleteById(Long roleId){
        baseRoleService.deleteById(roleId);
        return  Message.success("删除成功");
    }

    public Message<String> saveOrUpdate(BaseRole role){
        baseRoleService.saveOrUpdate(role);
        return Message.success("更新成功");
    }

    @ApiOperation("为角色授权")
    @GetMapping("authorization")
    public Message authorization(Long id,@RequestParam List<Long> privilegeIds){
        baseRoleService.authorization(id,privilegeIds);
        return Message.success("授权成功");
    }
}
