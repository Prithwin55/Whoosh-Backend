package com.whoosh_backend.Whoosh_Backend.data.entity.servicecategory;

import com.whoosh_backend.Whoosh_Backend.data.entity.item.Item;
import com.whoosh_backend.Whoosh_Backend.data.enums.ServiceType;
import com.whoosh_backend.Whoosh_Backend.data.entity.laundryshop.LaundryShop;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service_categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType; // LAUNDRY, IRONING

    @OneToMany(mappedBy = "serviceCategory",cascade = CascadeType.ALL)

    private List<Item> items=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "laundry_shop_id", referencedColumnName = "id")
    private LaundryShop laundryShop;
}