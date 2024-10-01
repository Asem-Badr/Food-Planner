package com.example.foodplanner.home.presenter;

import android.content.Context;

import com.example.foodplanner.model.Meal;

public interface HomePresenter {
    public void getRandomMeal();
    public void getCategories();
    public void getCountries();
    public void addToFav(Meal meal);
}
