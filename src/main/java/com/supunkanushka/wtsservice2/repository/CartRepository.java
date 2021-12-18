package com.supunkanushka.wtsservice2.repository;

import com.supunkanushka.wtsservice2.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CartRepository extends MongoRepository<Cart, String> {

	List<Cart> findByProductName();
}
