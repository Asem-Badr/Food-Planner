package com.example.foodplanner.network;

import com.example.foodplanner.model.Meal;

import java.util.List;

public interface FilterMealsByCategoryCallback {
    public void onSuccessFilterByCategoryResult(List<Meal> meals);

    public void onFailureFilterByCategoryResult(String errorMsg);
}
