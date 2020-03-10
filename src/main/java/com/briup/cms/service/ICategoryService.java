package com.briup.cms.service;

import com.briup.cms.bean.Category;
import com.briup.cms.utils.CustomerException;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void saveOrUpdate(Category category) throws CustomerException;

    void deleteById(Long id) throws CustomerException;

    void bathDelete(Long[] ids) throws CustomerException;
}
