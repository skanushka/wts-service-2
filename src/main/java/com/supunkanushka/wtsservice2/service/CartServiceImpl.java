package com.supunkanushka.wtsservice2.service;

import com.supunkanushka.wtsservice2.model.Cart;
import com.supunkanushka.wtsservice2.model.CartRequest;
import com.supunkanushka.wtsservice2.repository.CartRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class CartServiceImpl implements CartService {

	private final CartRepository cartRepository;

	private final RestTemplateBuilder restTemplateBuilder;

	@Override
	public Cart save(CartRequest cartRequest) {

		String url = String.format("http://localhost:8080/product/%d", cartRequest.getProductId());
		Cart.Product product = restTemplateBuilder.build().getForObject(url, Cart.Product.class);

		Cart cart = new Cart();
		cart.setProduct(product);
		cart.setQty(cartRequest.getQty());

		return cartRepository.save(cart);
	}

	@Override
	public Optional<Cart> fetchCartById(@NonNull String id) {
		return cartRepository.findById(id);
	}

	@Override
	public List<Cart> fetchAllCarts() {
		return cartRepository.findAll();
	}

	@Override
	public List<Cart> fetchCartsByProduct() {
		return cartRepository.findByProductName();
	}
}
