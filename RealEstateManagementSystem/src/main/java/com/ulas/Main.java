package com.ulas;

import com.ulas.entity.House;
import com.ulas.entity.Property;

import com.ulas.entity.SummerHouse;
import com.ulas.entity.Villa;
import com.ulas.managment.PropertyManagement;

import com.ulas.service.PropertyService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        PropertyManagement management = new PropertyManagement();
        PropertyService service = new PropertyService();

        management.addHouse(new House(120000, 120, 3, 1));
        management.addVilla(new Villa(300000, 200, 4, 2));
        management.addSummerHouse(new SummerHouse(150000, 150, 3, 2));

        System.out.println("Total House Price: " + service.calculateTotalPrice(management.getHouses()));
        System.out.println("Total Villa Price: " + service.calculateTotalPrice(management.getVillas()));
        System.out.println("Total Summer House Price: " + service.calculateTotalPrice(management.getSummerHouses()));
        System.out.println("Total Price of All Properties: " + service.calculateTotalPrice(management.getAllProperties()));

        System.out.println("Average Area of Houses: " + service.calculateAverageArea(management.getHouses()));
        System.out.println("Average Area of Villas: " + service.calculateAverageArea(management.getVillas()));
        System.out.println("Average Area of Summer Houses: " + service.calculateAverageArea(management.getSummerHouses()));
        System.out.println("Average Area of All Properties: " + service.calculateAverageArea(management.getAllProperties()));

        List<Property> filteredProperties = service.filterProperties(management.getAllProperties(), 3, 1);
        System.out.println("Properties with 3 Bedrooms and 1 Living Room: " + filteredProperties.size());
    }
}