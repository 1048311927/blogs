package com.briup.cms.service.Impl;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.ArticleExample;
import com.briup.cms.bean.extend.ArticleExtend;
import com.briup.cms.dao.ArticleMapper;
import com.briup.cms.dao.extend.ArticleExtendMapper;
import com.briup.cms.service.IArticleService;
import com.briup.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class ArticleService implements IArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleExtendMapper articleExtendMapper;
    @Override
    public List<Article> findAll() {

        return articleMapper.selectByExample(new ArticleExample());
    }

    @Override
    public ArticleExtend findById(Long id) {
        return articleExtendMapper.selectById(id);
    }

    @Override
    public void saveOrUpdate(Article article) {
        if(article.getId() != null){
            articleMapper.updateByPrimaryKey(article);
        }else {
            //标题不能重名
            ArticleExample articleExample = new ArticleExample();
            articleExample.createCriteria().andTitleEqualTo(article.getTitle());
            List<Article> articles = articleMapper.selectByExample(articleExample);
            if(articles.size() > 0){
                throw new CustomerException("标题不能重复");
            }
            //初始化
            article.setPublishTime(new Date().getTime());
            article.setStatus(ArticleExtend.STATUS_UNCHECK);
            article.setThumpUp(0l);
            article.setThumpDown(0l);
            articleMapper.insert(article);
        }
    }

    @Override
    public List<ArticleExtend> cascadeFindAll() {

        return articleExtendMapper.selectAll();
    }
}
