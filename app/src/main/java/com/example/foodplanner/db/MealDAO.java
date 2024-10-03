package com.example.foodplanner.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.foodplanner.model.Meal;
import com.example.foodplanner.model.PlannedMeal;

import java.util.List;

@Dao
public interface MealDAO {
    @Query("SELECT * FROM meals_table")
    LiveData<List<Meal>> getAllMeals();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMeal(Meal meal);

    @Delete
    void deleteMeal(Meal meal);

    @Query("SELECT * FROM meals_planned WHERE date = :date")
    LiveData<List<PlannedMeal>> getPlannedMeals(long date);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertIntoPlanned(PlannedMeal meal);

    @Delete
    void deleteFromPlanned(PlannedMeal meal);

}
