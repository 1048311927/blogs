package com.briup.cms.web.controller;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.utils.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/category")
@Validated
@Api(description = "栏目模块")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("findAll")
    @ApiOperation("查询所有栏目")
    public Message<List<Category>> findAll(){
        return Message.success(categoryService.findAll());
    }

    @ApiOperation("通过Id删除栏目信息")
    @GetMapping("deleteById")
    @ApiImplicitParam(name = "id",value = "栏目Id",paramType = "query",dataType = "long")
    public Message<String> deleteById(Long id){
        categoryService.deleteById(id);
        return Message.success("删除成功");
    }

    @ApiOperation("批量删除栏目")
    @GetMapping("bathDelete")
    public Message<String> bathDelete(Long[] ids){
        categoryService.bathDelete(ids);
        return Message.success("删除成功");
    }

    @ApiOperation("保存或更新")
    @PostMapping("saveOrUpdata")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "栏目id",paramType = "query"),
            @ApiImplicitParam(name = "name",value = "栏目名称",paramType = "query"),
            @ApiImplicitParam(name = "description",value = "栏目描述",paramType = "query"),
            @ApiImplicitParam(name = "no",value = "序号",paramType = "query"),
            @ApiImplicitParam(name = "parentId",value = "父栏目id",paramType = "query"),

    })
    public Message<String> saveOrUpdate(
            Long id,
            @NotNull String name,
            String description,
            Integer no,
            Long parentId
    ){
        Category category = new Category();
        category.setId(id);
        category.setDescription(description);
        category.setName(name);
        category.setNo(no);
        category.setParentId(parentId);
        categoryService.saveOrUpdate(category);
        return Message.success("更新成功");
    }
}
