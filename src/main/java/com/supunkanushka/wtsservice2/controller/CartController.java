package com.supunkanushka.wtsservice2.controller;

import com.supunkanushka.wtsservice2.model.Cart;
import com.supunkanushka.wtsservice2.model.CartRequest;
import com.supunkanushka.wtsservice2.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class CartController {

	private final CartService cartService;

	@PostMapping(path = "/cart")
	public Cart save(@RequestBody CartRequest cartRequest) {
		return cartService.save(cartRequest);
	}

	@GetMapping(path = "/cart/{id}")
	public ResponseEntity<Cart> fetchcart(@PathVariable("id") String id) {
		Cart cart = cartService.fetchCartById(id).orElse(null);
		if (cart == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cart);
	}

	@GetMapping(path = "/cart")
	public ResponseEntity<List<Cart>> fetchCarts() {
		List<Cart> carts = cartService.fetchAllCarts();

		return ResponseEntity.ok(carts);
	}
}
