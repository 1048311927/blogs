package com.briup.cms.dao.extend;

import com.briup.cms.bean.Comment;

import java.util.List;

public interface CommentsExtendMapper {
    List<Comment> selectByArticleId(long articleId);
}
