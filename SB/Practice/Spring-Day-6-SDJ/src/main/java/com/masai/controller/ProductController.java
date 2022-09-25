package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Product;
import com.masai.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService pService;
	
	@PostMapping("/product")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		
		Product sProduct = pService.insertProduct(product);
		
		return new ResponseEntity<Product>(sProduct,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id){
		
		Product p = pService.getProductById(id);
		
		return new ResponseEntity<Product>(p, HttpStatus.OK);
		
	}
	
	@GetMapping("products")
	public ResponseEntity<List<Product>> getProduct(){
		
		List<Product> products = pService.getAllProducts();
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/products/{roll}")
	public ResponseEntity<Product> deleteStudentHandler(@PathVariable Integer roll) {

		Product dProduct =  pService.deleteProduct(roll);
		
		return new ResponseEntity<Product>(dProduct, HttpStatus.OK);
	}
}
