package com.whoosh_backend.Whoosh_Backend.data.entity.cartitem;

import com.whoosh_backend.Whoosh_Backend.data.entity.cart.Cart;
import com.whoosh_backend.Whoosh_Backend.data.entity.item.Item;
import com.whoosh_backend.Whoosh_Backend.data.entity.servicecategory.ServiceCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_items")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

//    @ManyToOne
//    @JoinColumn(name = "category_id", referencedColumnName = "id")
//    private ServiceCategory serviceCategory; // Category (Laundry/Ironing) linked to an Item
//

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    private Integer quantity;
    private Double totalPrice;
}
