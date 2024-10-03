package com.example.foodplanner.planner.view;

import androidx.lifecycle.LiveData;

import com.example.foodplanner.model.PlannedMeal;

import java.util.List;

public interface PlanView {
    void observeMeals(LiveData<List<PlannedMeal>> products);
    void showErrMsg(String error);
}
