package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptionHandler.InvalidProductId;
import com.masai.exceptionHandler.ProductException;
import com.masai.model.Product;
import com.masai.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao pDao;

	@Override
	public Product insertProduct(Product product) {

		return pDao.save(product);

	}

	@Override
	public List<Product> getAllProducts() {

		List<Product> products = pDao.findAll();
		if (products.size() > 0) {
			return products;
		} else {
			throw new ProductException("No product data available");
		}
	}

	@Override
	public Product getProductById(Integer pId) {

		Optional<Product> product = pDao.findById(pId);

		return product.orElseThrow(() -> new InvalidProductId("No Product AVailable for Id: " + pId));

	}

	@Override
	public Product deleteProduct(Integer pId) {

		Product product = pDao.findById(pId).orElseThrow(() -> new ProductException("Product does not exist.."));

		pDao.delete(product);

		return product;
	}

}
