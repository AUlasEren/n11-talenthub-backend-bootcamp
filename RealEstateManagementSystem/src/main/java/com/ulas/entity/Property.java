package com.ulas.entity;

public abstract class Property {
    protected double price;
    protected double area;
    protected int bedroomCount;
    protected int livingRoomCount;

    public Property(double price, double area, int bedroomCount, int livingRoomCount) {
        this.price = price;
        this.area = area;
        this.bedroomCount = bedroomCount;
        this.livingRoomCount = livingRoomCount;
    }

    public double getPrice() {
        return price;
    }

    public double getArea() {
        return area;
    }

    public int getBedroomCount() {
        return bedroomCount;
    }

    public int getLivingRoomCount() {
        return livingRoomCount;
    }
}