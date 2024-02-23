package com.ulas.entity;

import com.ulas.entity.impl.Entity;
import com.ulas.entity.impl.Pricable;

public class Product extends Entity implements Pricable {

    private final String name;
    private final double price;
    @Override
    public double getPrice() {
        return price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }


}
