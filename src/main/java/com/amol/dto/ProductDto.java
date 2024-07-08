package com.amol.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {
	
	private int productId;
	private String productName;
	private Integer qty;
	private Double price;
	
	

}
