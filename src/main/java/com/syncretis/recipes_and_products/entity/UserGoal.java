package com.syncretis.recipes_and_products.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "user_goal", schema = "azure")
public class UserGoal {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "goal_weight")
    private double goalWeight;
    @Column(name = "KCal_per_day")
    private double kCalPerDay;

    public UserGoal() {
    }

    public UserGoal(String userId, double goalWeight, double kCalPerDay) {
        this.userId = userId;
        this.goalWeight = goalWeight;
        this.kCalPerDay = kCalPerDay;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(double goalWeight) {
        this.goalWeight = goalWeight;
    }

    public double getKCalPerDay() {
        return kCalPerDay;
    }

    public void setKCalPerDay(double kCalPerDay) {
        this.kCalPerDay = kCalPerDay;
    }

    @Override
    public String toString() {
        return "UserGoal{" +
                "userId='" + userId + '\'' +
                ", goalWeight=" + goalWeight +
                ", kCalPerDay=" + kCalPerDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGoal userGoal = (UserGoal) o;
        return Objects.equals(userId, userGoal.userId) && Objects.equals(goalWeight, userGoal.goalWeight) && Objects.equals(kCalPerDay, userGoal.kCalPerDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, goalWeight, kCalPerDay);
    }
}
