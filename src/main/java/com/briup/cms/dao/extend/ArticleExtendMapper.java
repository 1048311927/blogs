package com.briup.cms.dao.extend;

import com.briup.cms.bean.extend.ArticleExtend;

import java.util.List;

public interface ArticleExtendMapper {
    List<ArticleExtend>  selectAll();
    ArticleExtend selectById(Long id);
}
