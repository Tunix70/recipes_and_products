package com.syncretis.recipes_and_products.dto.rap;

import java.util.Objects;

public class RecipeDto {
    private String name;
    private boolean glutenFree;
    private boolean dairyFree;

    public RecipeDto() {
    }

    public RecipeDto(String name, boolean glutenFree, boolean dairyFree) {
        this.name = name;
        this.glutenFree = glutenFree;
        this.dairyFree = dairyFree;
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
        RecipeDto recipeDto = (RecipeDto) o;
        return glutenFree == recipeDto.glutenFree && dairyFree == recipeDto.dairyFree && Objects.equals(name, recipeDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, glutenFree, dairyFree);
    }
}
