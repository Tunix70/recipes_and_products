package com.syncretis.recipes_and_products.dto.domain;

import java.util.Objects;

public class Recipe {
    private long id;
    private String name;
    private boolean glutenFree;
    private boolean dairyFree;

    public Recipe() {
    }

    public Recipe(long id, String name, boolean glutenFree, boolean dairyFree) {
        this.id = id;
        this.name = name;
        this.glutenFree = glutenFree;
        this.dairyFree = dairyFree;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public boolean isDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(boolean dairyFree) {
        this.dairyFree = dairyFree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe that = (Recipe) o;
        return id == that.id && glutenFree == that.glutenFree && dairyFree == that.dairyFree && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, glutenFree, dairyFree);
    }
}
