package com.craigmgordon.productservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@GetMapping(path = "/products")
	@CrossOrigin("http://localhost:20000")
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		Product product1 = new Product("A3245", "Lawnmower");
		Product product2 = new Product("X3245", "iPhone");

		products.add(product1);
		products.add(product2);

		return products;
	}
}
