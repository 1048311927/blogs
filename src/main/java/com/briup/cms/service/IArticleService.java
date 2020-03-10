package com.briup.cms.service;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.extend.ArticleExtend;
import com.briup.cms.utils.CustomerException;

import java.util.List;

public interface IArticleService {
    List<Article> findAll();
    List<ArticleExtend> cascadeFindAll();
    ArticleExtend findById(Long id);
    void saveOrUpdate(Article article) throws CustomerException;
}
