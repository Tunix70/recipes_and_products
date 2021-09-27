package com.syncretis.recipes_and_products.dto.spoonacular;

public class WeightPerServingResponseDto {
    private long amount;
    private String unit;

    public WeightPerServingResponseDto() {
    }

    public WeightPerServingResponseDto(long amount, String unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "WeightPerServingResponseDto{" +
                "amount=" + amount +
                ", unit='" + unit + '\'' +
                '}';
    }
}