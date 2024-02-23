package com.ulas.entity;

public class Invoice {
    private Order order;

    public Invoice(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public double getTotalPrice() {
        return order.getProducts().stream().mapToDouble(Product::getPrice).sum();
    }
}
