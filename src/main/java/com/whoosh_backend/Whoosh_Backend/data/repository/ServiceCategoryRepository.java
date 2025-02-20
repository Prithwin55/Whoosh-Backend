package com.whoosh_backend.Whoosh_Backend.data.repository;

import com.whoosh_backend.Whoosh_Backend.data.entity.laundryshop.LaundryShop;
import com.whoosh_backend.Whoosh_Backend.data.entity.servicecategory.ServiceCategory;
import com.whoosh_backend.Whoosh_Backend.data.enums.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Long> {
    Optional<ServiceCategory> findByLaundryShopAndServiceType(LaundryShop laundryShop, ServiceType serviceType);
    List<ServiceCategory> findAllByLaundryShopId(long shopId);
    List<ServiceCategory> findAllByServiceType(ServiceType serviceType);
    List<ServiceCategory> findAllByLaundryShopIdAndServiceType(long shopId, ServiceType serviceType);


}
