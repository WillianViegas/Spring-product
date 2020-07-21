package com.willian.springproduct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willian.springproduct.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
