package com.syncretis.recipes_and_products.dto.rap;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

public class UserParametersDto {
    @JsonProperty(value = "gender")
    private String gender;
    @JsonProperty(value = "age")
    private int age;
    @JsonProperty(value = "weight")
    private double weight;
    @JsonProperty(value = "height")
    private int height;
    @JsonProperty(value = "bmi")
    private double bmi;

    public UserParametersDto() {
    }

    public UserParametersDto(String gender, int age, double weight, int height, double bmi) {
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
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
        return new StringJoiner(", ", UserParametersDto.class.getSimpleName() + "[", "]")
                .add("gender='" + gender + "'")
                .add("age=" + age)
                .add("weight=" + weight)
                .add("height=" + height)
                .add("bmi=" + bmi)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserParametersDto that = (UserParametersDto) o;
        return age == that.age && Double.compare(that.weight, weight) == 0 && height == that.height && Double.compare(that.bmi, bmi) == 0 && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, age, weight, height, bmi);
    }
}