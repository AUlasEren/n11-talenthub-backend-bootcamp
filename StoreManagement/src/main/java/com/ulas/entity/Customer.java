package com.ulas.entity;

import com.ulas.entity.impl.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer extends Entity {
    private String name;
    private List<Order> orders;
    private LocalDate registrationDate;
    private String sector;

    public Customer(String name, LocalDate registrationDate, String sector) {
        this.name = name;
        this.orders = new ArrayList<>();
        this.registrationDate = registrationDate;
        this.sector = sector;
    }

    public String getSector() {
        return sector;
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
