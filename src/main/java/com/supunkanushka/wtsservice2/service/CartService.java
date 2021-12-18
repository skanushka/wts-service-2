package com.supunkanushka.wtsservice2.service;

import com.supunkanushka.wtsservice2.model.Cart;
import com.supunkanushka.wtsservice2.model.CartRequest;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface CartService {

	Cart save(CartRequest cartRequest);

	Optional<Cart> fetchCartById(@NonNull String id);

	List<Cart> fetchAllCarts();

	List<Cart> fetchCartsByProduct();
}
