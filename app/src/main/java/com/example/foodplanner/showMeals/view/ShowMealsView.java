package com.example.foodplanner.showMeals.view;

import com.example.foodplanner.model.Meal;

import java.util.List;

public interface ShowMealsView {

    public void showResults(List<Meal> meals);
    public void showErrorMessage(String error);
}
