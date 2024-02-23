package com.blps.demo.repository;

import com.blps.demo.entity.Cart;
import com.blps.demo.entity.compositekey.CartId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartId> {
    List<Cart> findByProductId(int productId);

    List<Cart> findByClientId(int productId);
}
