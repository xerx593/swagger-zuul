package com.craigmgordon.productservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
public class ProductController {
	
	
	@GetMapping(path="/products")
	public List<Product> getProducts(){
		List<Product>products = new ArrayList<Product>();
		Product product1 = new Product("A3245", "Lawnmower");
		Product product2 = new Product("X3245", "iPhone");
		
		products.add(product1);
		products.add(product2);
		
		return products;
	}
}
