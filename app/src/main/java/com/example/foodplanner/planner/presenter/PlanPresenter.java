package com.example.foodplanner.planner.presenter;


import com.example.foodplanner.model.PlannedMeal;

public interface PlanPresenter {
    public void getPlannedMeals(long date);

    public void removeFromPlan(PlannedMeal meal);
}
