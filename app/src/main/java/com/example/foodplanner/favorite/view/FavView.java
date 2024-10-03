package com.example.foodplanner.favorite.view;

import androidx.lifecycle.LiveData;

import com.example.foodplanner.model.Meal;

import java.util.List;

public interface FavView {
    void observeMeals(LiveData<List<Meal>> meals);
    void showErrMsg(String error);
}
