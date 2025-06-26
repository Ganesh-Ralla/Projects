package com.bookstore.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private int addressId;
    private String paymentMethod;
    private List<OrderItemsRequest> items;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderItemsRequest {
        private int bookid;
        private String title;
        private int quantity;
        private double price;

    }
}
