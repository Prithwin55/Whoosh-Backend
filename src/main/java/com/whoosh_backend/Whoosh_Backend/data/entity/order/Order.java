package com.whoosh_backend.Whoosh_Backend.data.entity.order;
import com.whoosh_backend.Whoosh_Backend.data.entity.laundryshop.LaundryShop;
import com.whoosh_backend.Whoosh_Backend.data.entity.orderItem.OrderItem;
import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
import com.whoosh_backend.Whoosh_Backend.data.enums.OrderStatus;
import com.whoosh_backend.Whoosh_Backend.data.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private LaundryShop shop;

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // PENDING, PICKED_UP, IN_PROCESS, COMPLETED, DELIVERED

    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus; // PENDING, PAID, FAILED

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}
