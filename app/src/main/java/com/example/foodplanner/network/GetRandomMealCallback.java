package com.example.foodplanner.network;

import com.example.foodplanner.model.Meal;

import java.util.List;

public interface GetRandomMealCallback {
    public void onSuccessRandomResult(List<Meal> meals);
    public void onFailureRandomResult(String errorMsg);
}
