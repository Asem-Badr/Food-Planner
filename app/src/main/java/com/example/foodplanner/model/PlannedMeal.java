package com.example.foodplanner.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity(tableName = "meals_planned", primaryKeys = {"idMealPlanned", "date"})
public class PlannedMeal {

    @Embedded
    private Meal meal;
    private int idMealPlanned;
    private long date;

    // Getters and Setters

    public PlannedMeal() {
    }

    @Ignore
    public PlannedMeal(Meal meal, long date) {
        this.meal = meal;
        this.date = date;
        idMealPlanned = meal.getIdMeal();
    }

    public int getIdMealPlanned() {
        return idMealPlanned;
    }

    public void setIdMealPlanned(int idMealPlanned) {
        this.idMealPlanned = idMealPlanned;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
