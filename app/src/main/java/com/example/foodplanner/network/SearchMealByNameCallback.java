package com.example.foodplanner.network;

import com.example.foodplanner.model.Meal;

import java.util.List;

public interface SearchMealByNameCallback {
    public void onSuccessResult(List<Meal> meals);
    public void onFailureResult(String errorMsg);
}
