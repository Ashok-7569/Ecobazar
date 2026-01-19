package com.infosys.ecobazar.Ecobazar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infosys.ecobazar.Ecobazar.entity.Product;
import com.infosys.ecobazar.Ecobazar.entity.ProductStatus;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // ---------------- USER VIEW ----------------

    List<Product> findByStatus(ProductStatus status);

    // ---------------- SEARCH ----------------

    List<Product> findByNameContainingIgnoreCaseAndStatus(
            String name,
            ProductStatus status
    );

    // ---------------- FILTERS ----------------

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

    // ---------------- SORT ----------------

    List<Product> findAllByStatusOrderByPriceAsc(ProductStatus status);

    List<Product> findAllByStatusOrderByCarbonImpactAsc(ProductStatus status);

    // ---------------- ⭐ FIXED METHOD ⭐ ----------------
    // KEEPING SAME NAME: findByEcoRatingAndStatus1

    @Query("""
           SELECT p FROM Product p
           WHERE p.ecoRating = :ecoRating
           AND p.status = :status
           """)
    List<Product> findByEcoRatingAndStatus1(
            @Param("ecoRating") String ecoRating,
            @Param("status") ProductStatus status
    );

    // ---------------- RATING FILTER ----------------

    List<Product> findByRatingGreaterThanEqualAndStatus(
            double rating,
            ProductStatus status
    );
}
