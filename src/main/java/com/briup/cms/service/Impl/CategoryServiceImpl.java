package com.briup.cms.service.Impl;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.CategoryExample;
import com.briup.cms.dao.CategoryMapper;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.utils.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> findAll() {
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public void saveOrUpdate(Category category) throws CustomerException {
        if (category.getId() != null){
            categoryMapper.updateByPrimaryKey(category);
        }else {
            CategoryExample example = new CategoryExample();
            example.createCriteria().andNameEqualTo(category.getName());
            List<Category> list = categoryMapper.selectByExample(example);
            if (list.size() > 0){
                throw new CustomerException("该栏目已经存在");
            }
            categoryMapper.insert(category);
        }
    }
    @Transactional
    @Override
    public void deleteById(Long id) throws CustomerException {
        Category category = categoryMapper.selectByPrimaryKey(id);
        if (category == null){
            throw new CustomerException("要删除的栏目不存在");
        }
        categoryMapper.deleteByPrimaryKey(id);
    }
    @Transactional
    @Override
    public void bathDelete(Long[] ids) throws CustomerException {
        for (long id : ids){
            this.deleteById(id);
        }
    }
}
