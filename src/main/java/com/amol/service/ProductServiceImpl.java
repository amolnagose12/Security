package com.amol.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amol.dto.ProductDto;
import com.amol.entity.UserInfo;
import com.amol.repository.UserInfoRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductServiceImpl{

	List<ProductDto> productList = null;

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public String loadProductsFromDB() {
        return "Product List";
    }    


    public List<ProductDto> getProducts() {
        return productList;
    }

    public ProductDto getProduct(int id) {
        return productList.stream()
                .filter(product -> product.getProductId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("product " + id + " not found"));
    }
    
    public String addUser(UserInfo userInfo) {
    	userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
    	repository.save(userInfo);
    	return "user added to system";
    }
	
    
    
	
}	
								
		

				
		
	
	
