package com.example.foodplanner.showMeal.presenter;

import com.example.foodplanner.model.Meal;

public interface ShowMealPresenter {
    public void addToFav(Meal meal);

    public void removeFromFav(Meal meal);
}
