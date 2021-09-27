package com.syncretis.recipes_and_products.domain;

import java.util.Objects;

public class Activity {
    private String name;
    private double burntCalories;
    private double durationInMinutes;

    public Activity() {
    }

    public Activity(String name, double burntCalories, double durationInMinutes) {
        this.name = name;
        this.burntCalories = burntCalories;
        this.durationInMinutes = durationInMinutes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBurntCalories() {
        return burntCalories;
    }

    public void setBurntCalories(double burntCalories) {
        this.burntCalories = burntCalories;
    }

    public double getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(double durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity domain = (Activity) o;
        return Double.compare(domain.burntCalories, burntCalories) == 0 &&
                Double.compare(domain.durationInMinutes, durationInMinutes) == 0 &&
                name.equals(domain.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, burntCalories, durationInMinutes);
    }

    @Override
    public String toString() {
        return "ActivityDomain{" +
                "name='" + name + '\'' +
                ", burntCalories=" + burntCalories +
                ", durationInMinutes=" + durationInMinutes +
                '}';
    }
}