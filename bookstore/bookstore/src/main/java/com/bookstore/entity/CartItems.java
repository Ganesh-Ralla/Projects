package com.bookstore.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "cartItems")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "book_id")
    //@JsonManagedReference
    private Book book;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    //@JsonBackReference
    private Cart cart;

    private double price;

}
