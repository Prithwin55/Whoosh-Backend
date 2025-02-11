package com.whoosh_backend.Whoosh_Backend.data.entity.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.whoosh_backend.Whoosh_Backend.data.entity.servicecategory.ServiceCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private String itemName;
    @ManyToOne
    @JoinColumn(name = "service_category_id", referencedColumnName = "id")
    @JsonIgnore
    private ServiceCategory serviceCategory;
}