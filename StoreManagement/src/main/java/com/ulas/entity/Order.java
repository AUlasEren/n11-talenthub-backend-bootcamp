package com.ulas.entity;

import com.ulas.entity.impl.Entity;
import com.ulas.entity.impl.Pricable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order extends Entity implements Pricable {
    private List<Product> products;
    private LocalDate orderDate;

    public Order() {
        this.products = new ArrayList<>();
    }

    public Order(LocalDate orderDate) {
        this.products = new ArrayList<>();
        this.orderDate = orderDate;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
    public double calculateTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public double getPrice() {
        return calculateTotalPrice();
    }
}
