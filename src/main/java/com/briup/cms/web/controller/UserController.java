package com.briup.cms.web.controller;

import com.briup.cms.Vm.UserVM;
import com.briup.cms.bean.BaseUser;
import com.briup.cms.bean.extend.BaseUserExtend;
import com.briup.cms.service.Impl.BaseUserService;
import com.briup.cms.utils.JwtTokenUtil;
import com.briup.cms.utils.Message;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    BaseUserService baseUserService;

    @PostMapping("login")
    public Message<Map<String,String>> login(@RequestBody UserVM userVM){
        // 1. 认证用户的用户名和密码
        BaseUser user = baseUserService.login(userVM);
        // 2. 如果登录成功产生token,将token缓存起来，返回
        String token = JwtTokenUtil.createJWT(user.getId(), user.getUsername());
        // 3. 如果登录失败
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return Message.success(map);
    }



    @ApiOperation(value = "通过token获取用户的基本信息")
    @GetMapping("info")
    public Message<BaseUserExtend> info(String token){
        // 1. 通过token获取用户信息  {id,use,gender,roles:[]}
        long id = Long.parseLong(JwtTokenUtil.getUserId(token,JwtTokenUtil.base64Secret));
        BaseUserExtend baseUserExtend = baseUserService.findById(id);
        return Message.success(baseUserExtend);
    }

    @PostMapping("logout")
    public Message<String> logout(){
        //1.登录,token从缓存中移除掉
        return Message.success("退出成功");
        
    }

    @GetMapping("setRoles")
    @ApiOperation("通过用户id给用户设置角色")
    public Message<String> setRoles(Long userId,@RequestParam List<Long> rolesId){
        baseUserService.setRoles(userId,rolesId);
        return Message.success("角色设置成功");
    }

    @GetMapping("findByUserId")
    @ApiOperation("通过userId查询用户信息包含用户角色")
    @ApiImplicitParam(name = "userId",value = "用户id",paramType = "query",dataType = "long",required = true)
    public Message<BaseUserExtend> findByUserId(@NotNull Long userId){
        BaseUserExtend user = baseUserService.findById(userId);
        return Message.success(user);
    }

}
