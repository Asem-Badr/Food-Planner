package com.example.foodplanner.home.view;

import com.example.foodplanner.model.Category;
import com.example.foodplanner.model.Meal;

import java.util.List;

public interface HomeView {
    public void showData(Meal meal);
    public void showCountries(List<Meal> countries);
    public void showCategories(List<Category> categories);
    public void showErrMsg(String error);
}
