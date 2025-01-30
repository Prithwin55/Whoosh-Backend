package com.whoosh_backend.Whoosh_Backend.data.entity.user;
import com.whoosh_backend.Whoosh_Backend.data.entity.delivery.Delivery;
import com.whoosh_backend.Whoosh_Backend.data.entity.laundryshop.LaundryShop;
import com.whoosh_backend.Whoosh_Backend.data.entity.order.Order;
import com.whoosh_backend.Whoosh_Backend.data.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role; // CUSTOMER, DELIVERY, LAUNDRY_SHOP
    private String address;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Order> orders;
//
//    @OneToMany(mappedBy = "deliveryPerson", cascade = CascadeType.ALL)
//    private List<Delivery> deliveries;
//
//    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
//    private LaundryShop laundryShop;

}
