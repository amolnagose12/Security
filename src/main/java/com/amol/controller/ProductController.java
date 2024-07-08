package com.amol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amol.dto.ProductDto;
import com.amol.entity.UserInfo;
import com.amol.service.ProductServiceImpl;


@RestController
@RequestMapping("/product")
public class ProductController {

	

	    @Autowired
	    private ProductServiceImpl service;

	    @GetMapping("/welcome")
	    public String welcome() {
	        return "Welcome this endpoint is not secure";
	    }

	    @PostMapping("/new")
	    public String addNewUser(@RequestBody UserInfo userInfo){
	        return service.addUser(userInfo);
	    }
//
//	    @GetMapping("/all")
//	    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//	    public List<ProductDto> getAllTheProducts() {
//	        return service.getProducts();
//	    }
//
//	    @GetMapping("/{id}")
//	    @PreAuthorize("hasAuthority('ROLE_USER')")
//	    public ProductDto getProductById(@PathVariable int id) {
//	        return service.getProduct(id);
//	    }
	
}
