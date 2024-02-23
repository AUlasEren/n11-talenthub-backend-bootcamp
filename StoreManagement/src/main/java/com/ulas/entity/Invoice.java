package com.ulas.entity;

import com.ulas.entity.impl.Pricable;

public class Invoice {
    private Pricable pricableItem;

    public Invoice(Pricable pricableItem) {
        this.pricableItem = pricableItem;
    }

    public Pricable getPricableItem() {
        return pricableItem;
    }

    public double getTotalPrice() {
        return pricableItem.getPrice();
    }
}
