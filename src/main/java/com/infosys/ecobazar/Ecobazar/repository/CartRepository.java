package com.infosys.ecobazar.Ecobazar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.ecobazar.Ecobazar.entity.CartItem;

public interface CartRepository extends JpaRepository<CartItem, Integer> {

    List<CartItem> findByUsername(String username);
}
