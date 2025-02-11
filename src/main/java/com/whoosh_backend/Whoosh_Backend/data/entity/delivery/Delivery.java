package com.whoosh_backend.Whoosh_Backend.data.entity.delivery;

import com.whoosh_backend.Whoosh_Backend.data.entity.order.Order;
import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
import com.whoosh_backend.Whoosh_Backend.data.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "delivery")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "delivery_person_id", referencedColumnName = "id")
    private User deliveryPerson;

    private LocalDateTime pickupTime;
    private LocalDateTime dropTime;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; // ASSIGNED, IN_TRANSIT, DELIVERED ,UNASSIGNED

}
