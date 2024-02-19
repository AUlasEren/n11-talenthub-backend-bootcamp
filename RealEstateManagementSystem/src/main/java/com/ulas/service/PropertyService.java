package com.ulas.service;

import com.ulas.entity.House;
import com.ulas.entity.Property;
import com.ulas.entity.SummerHouse;
import com.ulas.entity.Villa;

import java.util.List;
import java.util.stream.Collectors;

public class PropertyService {

    public double calculateTotalPrice(List<? extends Property> properties) {
        return properties.stream()
                .mapToDouble(Property::getPrice)
                .sum();
    }

    public double calculateAverageArea(List<? extends Property> properties) {
        if (properties.isEmpty()) {
            return 0.0;
        }
        return properties.stream()
                .mapToDouble(Property::getArea)
                .average()
                .orElse(0.0);
    }

    public List<Property> filterProperties(List<? extends Property> properties, int bedroomCount, int livingRoomCount) {
        return properties.stream()
                .filter(p -> p.getBedroomCount() == bedroomCount && p.getLivingRoomCount() == livingRoomCount)
                .collect(Collectors.toList());
    }
}
