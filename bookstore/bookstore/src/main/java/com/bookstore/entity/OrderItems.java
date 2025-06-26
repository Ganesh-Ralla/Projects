package com.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int bookid;
    @Column
    private String title;
    @Column
    private int quantity;
    @Column
    private double price;

    @ManyToOne
    @JoinColumn(name = "orderid")
    @JsonBackReference
    private Orders orders;
}
