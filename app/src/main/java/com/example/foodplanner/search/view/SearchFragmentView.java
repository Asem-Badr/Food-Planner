package com.example.foodplanner.search.view;

import com.example.foodplanner.model.Category;
import com.example.foodplanner.model.Meal;

import java.util.List;

public interface SearchFragmentView {

    public void showResults(List<Meal> meals);
    public void showErrorMessage(String error);
}
