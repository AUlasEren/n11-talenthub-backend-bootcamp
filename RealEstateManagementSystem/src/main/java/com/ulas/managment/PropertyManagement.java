package com.ulas.managment;

import com.ulas.entity.House;
import com.ulas.entity.Property;
import com.ulas.entity.SummerHouse;
import com.ulas.entity.Villa;

import java.util.ArrayList;
import java.util.List;

public class PropertyManagement {
    private List<House> houses = new ArrayList<>();
    private List<Villa> villas = new ArrayList<>();
    private List<SummerHouse> summerHouses = new ArrayList<>();

    public void addHouse(House house) {
        houses.add(house);
    }

    public void addVilla(Villa villa) {
        villas.add(villa);
    }

    public void addSummerHouse(SummerHouse summerHouse) {
        summerHouses.add(summerHouse);
    }

    public List<House> getHouses() {
        return new ArrayList<>(houses);
    }

    public List<Villa> getVillas() {
        return new ArrayList<>(villas);
    }

    public List<SummerHouse> getSummerHouses() {
        return new ArrayList<>(summerHouses);
    }

    public List<Property> getAllProperties() {
        List<Property> allProperties = new ArrayList<>();
        allProperties.addAll(houses);
        allProperties.addAll(villas);
        allProperties.addAll(summerHouses);
        return allProperties;
    }


}
