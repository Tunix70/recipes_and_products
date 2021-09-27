package com.syncretis.recipes_and_products.dto.spoonacular.recipe;

public class SpoonacularRecipeDto {
    private long id;
    private String title;
    private boolean glutenFree;
    private boolean dairyFree;

    public SpoonacularRecipeDto() {
    }

    public SpoonacularRecipeDto(long id, String title, boolean glutenFree, boolean dairyFree) {
        this.id = id;
        this.title = title;
        this.glutenFree = glutenFree;
        this.dairyFree = dairyFree;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ResultOfRecipesSearchDto{" +
                "title='" + title + '\'' +
                ", glutenFree=" + glutenFree +
                ", dairyFree=" + dairyFree +
                '}';
    }
}
