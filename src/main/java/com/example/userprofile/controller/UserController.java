package com.example.userprofile.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userprofile.dto.ProductDTO;
import com.example.userprofile.model.Category;

import com.example.userprofile.model.UserModel;
import com.example.userprofile.service.MyService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
	
	@Autowired
	private MyService myService;
	
	public UserController(MyService myService) {
		this.myService = myService;
	}


	@GetMapping("/")
	public String getUser() {
		return myService.greet("sam");
	}
	
	@PostMapping("/add")
	public ResponseEntity<UserModel>  addUsers(@Valid @RequestBody UserModel user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(myService.addUser(user));
		
	}
	@PostMapping("/addproduct")
	public ResponseEntity<ProductDTO>  addProductinfo(@Valid @RequestBody ProductDTO user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(myService.addProduct(user));
		
	}
//	@GetMapping("/product")
//	public ResponseEntity<List<Product>> allproduct() {
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(myService.showProduct());
//	}
	
	@GetMapping("/product")
	public ResponseEntity<List<ProductDTO>> searchproducts(@RequestParam(defaultValue = "") String search) {
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(myService.searchproduct(search));
	}
	
	@PostMapping("/addCategory")
	public ResponseEntity<Category> addcategories(@RequestBody Category category) {
		return ResponseEntity.status(HttpStatus.CREATED).body(myService.addCategory(category));
	}
	

}
