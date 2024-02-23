package com.ulas.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Order> orders;
    private LocalDate registrationDate;

    public Customer(String name, LocalDate registrationDate) {
        this.name = name;
        this.orders = new ArrayList<>();
        this.registrationDate = registrationDate;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}
