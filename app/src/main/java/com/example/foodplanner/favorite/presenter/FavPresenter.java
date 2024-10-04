package com.example.foodplanner.favorite.presenter;

import com.example.foodplanner.model.Meal;

public interface FavPresenter {
    public void getMeals();

    public void removeFromFav(Meal meal);

    public void addToFav(Meal meal);
}
