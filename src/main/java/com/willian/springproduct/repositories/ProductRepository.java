package com.willian.springproduct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willian.springproduct.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
