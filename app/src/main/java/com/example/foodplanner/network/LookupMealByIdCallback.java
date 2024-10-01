package com.example.foodplanner.network;

import com.example.foodplanner.model.Meal;

import java.util.List;

public interface LookupMealByIdCallback {
    public void onSuccessLookupMealById(List<Meal> meals);

    public void onFailureLookupMealById(String errorMsg);
}
