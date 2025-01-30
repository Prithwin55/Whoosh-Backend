package com.whoosh_backend.Whoosh_Backend.data.entity.laundryshop;

import com.whoosh_backend.Whoosh_Backend.data.entity.order.Order;
import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
import com.whoosh_backend.Whoosh_Backend.data.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "laundry_shops")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LaundryShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shopName;
    private String location;
    private String address;

    @Enumerated(EnumType.STRING)
    private Status status; // ACTIVE, INACTIVE

    @OneToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Order> orders;

}
