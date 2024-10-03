package com.example.foodplanner.db;

import androidx.lifecycle.LiveData;

import com.example.foodplanner.model.Meal;
import com.example.foodplanner.model.PlannedMeal;

import java.util.List;

public interface MealsLocalDataSource {
    void insertMeal(Meal meal);
    void deleteMeal(Meal meal);
    LiveData<List<Meal>> getAllStoredMeals();
    void insertIntoPlanned(PlannedMeal meal);
    void deleteFromPlanned(PlannedMeal meal);
    LiveData<List<PlannedMeal>> getPlannedMeals(long date);
}
