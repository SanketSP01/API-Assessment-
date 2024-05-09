package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.CategoryDao;
import com.demo.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	@Autowired
    private CategoryDao cs;

    @Override
    public List<Category> getAllCategories() {
        return cs.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return cs.save(category);
    }


    @Override
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = getCategoryById(id);
        existingCategory.setName(category.getName());
        return cs.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = getCategoryById(id);
        cs.delete(category);
    }

	@Override
	public Category getCategoryById(Long id) {
		return cs.getById(id);
	}

	@Override
	public Page<Category> getAllCategories(Pageable pageable) {
		return cs.findAll(pageable);
	}
}
