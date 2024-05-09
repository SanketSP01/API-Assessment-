package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao pd;

	@Override
    public List<Product> getAllProducts() {
        return pd.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return pd.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        return pd.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        pd.delete(product);
    }

	@Override
	public Product getProductById(Long id) {
		return pd.getById(id);
	}

	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		return pd.findAll(pageable);
	}

	
	
}
