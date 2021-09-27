package com.syncretis.recipes_and_products.dto.rap;

import java.util.Objects;

public class UserGoalDto {
    private double goalWeight;
    private double kCalPerDay;

    public UserGoalDto(double goalWeight, double kCalPerDay) {
        this.goalWeight = goalWeight;
        this.kCalPerDay = kCalPerDay;
    }

    public double getGoalWeight() {
        return goalWeight;
    }

    public double getKCalPerDay() {
        return kCalPerDay;
    }

    public void setGoalWeight(double goalWeight) {
        this.goalWeight = goalWeight;
    }

    public void setKCalPerDay(double kCalPerDay) {
        this.kCalPerDay = kCalPerDay;
    }

    @Override
    public String toString() {
        return "UserGoalDto{" +
                "goalWeight=" + goalWeight +
                ", kCalPerDay=" + kCalPerDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGoalDto that = (UserGoalDto) o;
        return Double.compare(that.goalWeight, goalWeight) == 0 && Double.compare(that.kCalPerDay, kCalPerDay) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goalWeight, kCalPerDay);
    }
}
