package com.syncretis.recipes_and_products.dto.spoonacular;

public class PropertiesResponseDto {
    private String name;
    private double amount;

    public PropertiesResponseDto() {
    }

    public PropertiesResponseDto(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PropertiesDtoResponse{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}