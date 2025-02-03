package com.whoosh_backend.Whoosh_Backend.data.repository;

import com.whoosh_backend.Whoosh_Backend.data.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
