package com.supunkanushka.wtsservice2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {

	private Integer productId;
	private Double qty;
}
