package com.example.foodplanner.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
@Entity(tableName = "meals_table")
public class Meal {
    @PrimaryKey
    @SerializedName("idMeal")
    private int idMeal;

    @SerializedName("strMeal")
    private String mealName;

    @SerializedName("strCategory")
    private String category;

    @SerializedName("strArea")
    private String area;

    @SerializedName("strInstructions")
    private String instructions;

    @SerializedName("strMealThumb")
    private String mealThumbnail;


    public Meal(int idMeal, String mealName, String category) {
        this.idMeal = idMeal;
        this.mealName = mealName;
        this.category = category;
    }
    @Ignore
    public Meal(int idMeal, String mealName, String category, String area, String instructions, String mealThumbnail) {
        this.idMeal = idMeal;
        this.mealName = mealName;
        this.category = category;
        this.area = area;
        this.instructions = instructions;
        this.mealThumbnail = mealThumbnail;
    }

    public int getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(int idMeal) {
        this.idMeal = idMeal;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getMealThumbnail() {
        return mealThumbnail;
    }

    public void setMealThumbnail(String mealThumbnail) {
        this.mealThumbnail = mealThumbnail;
    }



}

