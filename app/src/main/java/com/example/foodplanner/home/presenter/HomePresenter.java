package com.example.foodplanner.home.presenter;

import com.example.foodplanner.model.Meal;

public interface HomePresenter {
    public void getRandomMeal();
    public void addToFav(Meal meal);
    public void expandMeal(Meal meal);
}
