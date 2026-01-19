package com.infosys.ecobazar.Ecobazar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.ecobazar.Ecobazar.entity.Product;
import com.infosys.ecobazar.Ecobazar.entity.ProductStatus;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // =========================
    // USER VIEW (APPROVED ONLY)
    // =========================
    List<Product> findByStatus(ProductStatus status);

    // =========================
    // 🔍 SEARCH BY NAME
    // =========================
    List<Product> findByNameContainingIgnoreCaseAndStatus(
            String name,
            ProductStatus status
    );

    // =========================
    // 🔍 FILTERS (APPROVED ONLY)
    // =========================
    List<Product> findByCategoryIgnoreCaseAndStatus(
            String category,
            ProductStatus status
    );

    List<Product> findByEcoRatingAndStatus(
            String ecoRating,
            ProductStatus status
    );

    List<Product> findByPriceBetweenAndStatus(
            double min,
            double max,
            ProductStatus status
    );

    // =========================
    // 🔽 SORT (APPROVED ONLY)
    // =========================
    List<Product> findAllByStatusOrderByPriceAsc(ProductStatus status);

    List<Product> findAllByStatusOrderByCarbonImpactAsc(ProductStatus status);
}
