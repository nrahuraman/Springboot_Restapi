package com.example.demo;
import com.example.demo.Product;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductRestController {

	@PostMapping("/products")
	public String saveProduct(@RequestBody Product p)
	{
		System.out.println(p);
		return "Product saved";
		
	}
	
//	@GetMapping("/product/{pid}")
//	public Product getProduct(@PathVariable Integer pid)
//	{
//		Product p=null;
//		
//		if(pid==100)
//		{
//			p=new Product(100,"Mouse",500.00);
//			
//		}
//		else if(pid==101)
//		{
//			p=new Product(101,"HD",350.00);					
//		}
//		
//		return p;
//	}
//	}
	@GetMapping("/product/{pid}")
	public ResponseEntity<Product> getProduct(@PathVariable(name = "pid") Integer pid) {
	    Product product = null;

	    if (pid == 100) {
	        product = new Product(100, "Mouse", 500.00);
	    } else if (pid == 101) {
	        product = new Product(101, "HD", 350.00);
	    }

	    if (product != null) {
	        return new ResponseEntity<>(product, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	@GetMapping("/products")
	public List<Product> getProducts()
	{
		Product p1=new Product(100,"Mouse",500.00);	
		Product p2=new Product(101,"HD",350.00);
		List<Product> products = Arrays.asList(p1,p2);
		return products;
		
	}
}
