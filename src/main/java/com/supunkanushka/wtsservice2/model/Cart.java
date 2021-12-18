package com.supunkanushka.wtsservice2.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("cart")
@Setter
@Getter
public class Cart {

	@Id
	private String id;

	private Product product;

	private Double qty;


	@Getter
	@Setter
	public static class Product {
		private Integer id;
		private String name;
		private String description;
	}
}
