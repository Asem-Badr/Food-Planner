package com.example.foodplanner.network;

import com.example.foodplanner.model.Meal;

import java.util.List;

public interface FilterMealsByAreaCallback {
    public void onSuccessFilterByAreaResult(List<Meal> meals);

    public void onFailureFilterByAreaResult(String errorMsg);
}
