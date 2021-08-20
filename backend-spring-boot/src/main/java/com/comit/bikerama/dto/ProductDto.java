package com.comit.bikerama.dto;

import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProductDto {
	@NotBlank
	private String name;
	@Min(0)
	private BigDecimal price;

	public ProductDto() {}

	public ProductDto(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}
}
