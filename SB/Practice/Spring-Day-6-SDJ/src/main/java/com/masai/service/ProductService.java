package com.masai.service;

import java.util.List;

import com.masai.exceptionHandler.InvalidProductId;
import com.masai.exceptionHandler.ProductException;
import com.masai.model.Product;

public interface ProductService {

	public Product insertProduct(Product product);

	public List<Product> getAllProducts() throws ProductException;

	public Product getProductById(Integer pId) throws InvalidProductId;

	public Product deleteProduct(Integer pId) throws InvalidProductId;
}
