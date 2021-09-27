package com.syncretis.recipes_and_products.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "user_parameters", schema = "azure")
public class UserParameters {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private double weight;
    @Column(nullable = false)
    private int height;
    @Column(nullable = false)
    private double bmi;

    public UserParameters() {
    }

    public UserParameters(String userId, String gender, int age, double weight, int height, double bmi) {
        this.userId = userId;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    @Override
    public String toString() {
        return "UserParameters{" +
                "userId='" + userId + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", bmi=" + bmi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserParameters that = (UserParameters) o;
        return age == that.age && Double.compare(that.weight, weight) == 0 && height == that.height && Double.compare(that.bmi, bmi) == 0 && Objects.equals(userId, that.userId) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, gender, age, weight, height, bmi);
    }
}
