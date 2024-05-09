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

import com.demo.model.Product;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
    private ProductService ps;

	@GetMapping
	public ResponseEntity<Page<Product>> getAllProducts(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size,
	        @RequestParam(defaultValue = "id") String[] sort) {
	    Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
	    Page<Product> products = ps.getAllProducts(pageable);
	    return ResponseEntity.ok().body(products);
	}

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return ps.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(value = "id") Long id) {
        
    	return ps.getProductById(id);
   
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable(value = "id") Long id, @RequestBody Product product) {
        return ps.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long id) {
    	ps.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
