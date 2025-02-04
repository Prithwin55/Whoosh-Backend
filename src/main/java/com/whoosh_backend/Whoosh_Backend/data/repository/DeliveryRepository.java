package com.whoosh_backend.Whoosh_Backend.data.repository;

import com.whoosh_backend.Whoosh_Backend.data.entity.delivery.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}