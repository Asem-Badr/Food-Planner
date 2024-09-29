package com.example.foodplanner.network;

import com.example.foodplanner.model.Category;

import java.util.List;

public interface GetMealCategoriesCallback {
    public void onSuccessGetMealCategories(List<Category> categories);

    public void onFailureGetMealCategories(String errorMsg);
}
