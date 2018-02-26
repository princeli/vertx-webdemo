package com.princeli.vertx.webdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.princeli.vertx.webdemo.entity.Product;

/**
 * Spring Data JPA repository to connect our service bean to data
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
