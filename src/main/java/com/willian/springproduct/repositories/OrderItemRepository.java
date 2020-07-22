package com.willian.springproduct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willian.springproduct.domain.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
