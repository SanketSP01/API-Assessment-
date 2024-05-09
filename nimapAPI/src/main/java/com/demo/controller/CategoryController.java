package com.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Category;
import com.demo.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
    private CategoryService cs;

	@GetMapping
	public ResponseEntity<Page<Category>> getAllCategories(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size,
	        @RequestParam(defaultValue = "id") String[] sort) {
	    Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
	    Page<Category> categories = cs.getAllCategories(pageable);
	    return ResponseEntity.ok().body(categories);
	}

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return cs.createCategory(category);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable(value = "id") Long id) {
        return cs.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable(value = "id") Long id, @RequestBody Category category) {
        return cs.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(value = "id") Long id) {
    	cs.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
