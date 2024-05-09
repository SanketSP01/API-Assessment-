package com.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.demo.model.Product;

public interface ProductService {

	Page<Product> getAllProducts(Pageable pageable);
	List<Product> getAllProducts();
    Product createProduct(Product product);
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
	
	
}
