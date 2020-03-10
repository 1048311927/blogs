package com.briup.cms.web.controller;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.extend.ArticleExtend;
import com.briup.cms.service.IArticleService;
import com.briup.cms.utils.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
@Validated
@RestController
@RequestMapping("/article")
@Api("文章管理")
public class ArticleController {
    @Autowired
    private IArticleService articleService;
    @ApiOperation("查询所有文章")
    @GetMapping("findAll")
    public Message<List<Article>> findAll(){
        return Message.success(articleService.findAll());
    }


    @GetMapping("cascadeFindAll")
    @ApiOperation("级联查询所有文章")
    public Message<List<ArticleExtend>> cascadeFindAll(){
        return Message.success(articleService.cascadeFindAll());
    }


    @GetMapping("findById")
    @ApiOperation("通过Id查询文章信息")
    @ApiImplicitParam(name = "id",value = "文章Id",required = true, paramType = "query",dataType ="Long")
    public Message<ArticleExtend> findById(Long id){
        return Message.success(articleService.findById(id));
    }


    @PostMapping("saveOrUpdate")
    @ApiOperation(value = "保存或更新文章信息",notes = "如果参数中包含id后端认为是更新操作,如果参数中不包含id则认为是插入操作")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",value = "编号",paramType = "form",required = false),
            @ApiImplicitParam(name = "title",value = "标题",paramType = "form",required = true),
            @ApiImplicitParam(name = "content",value = "内容",paramType = "form",required = false),
            @ApiImplicitParam(name = "source",value = "源内容",paramType = "form",required = false),
            @ApiImplicitParam(name = "categoryId",value = "所属栏目Id",paramType = "form",required = true),
            @ApiImplicitParam(name = "authorId",value = "所属作者id",paramType = "form",required = false)})
    public Message<String> saveOrUpdate(
            Long id,
            @NotNull String title,
            @NotNull String content,
            String source,
            @NotNull long categoryId,
            Long authorId){
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setContent(content);
        article.setSource(source);
        article.setAuthorId(authorId);
        article.setCategoryId(categoryId);
        articleService.saveOrUpdate(article);
       return Message.success("保存成功");
    }
}
