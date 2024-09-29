package com.example.foodplanner.network;

import com.example.foodplanner.model.Meal;

import java.util.List;

public interface FilterMealsByIngredientCallback {
    public void onSuccessFilterByIngredientResult(List<Meal> meals);

    public void onFailureFilterByIngredientResult(String errorMsg);
}
