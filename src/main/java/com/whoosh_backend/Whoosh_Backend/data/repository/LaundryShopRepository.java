package com.whoosh_backend.Whoosh_Backend.data.repository;

import com.whoosh_backend.Whoosh_Backend.data.entity.laundryshop.LaundryShop;
import com.whoosh_backend.Whoosh_Backend.data.entity.servicecategory.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaundryShopRepository extends JpaRepository<LaundryShop, Long> {
}