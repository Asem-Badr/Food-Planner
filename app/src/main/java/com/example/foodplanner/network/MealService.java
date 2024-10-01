package com.example.foodplanner.network;

import com.example.foodplanner.model.CategoryResponse;
import com.example.foodplanner.model.MealResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealService {

    // 1. Search meal by name
    @GET("search.php")
    Call<MealResponse> searchMealByName(@Query("s") String mealName);

    // 2. List meals by first letter
    @GET("search.php")
    Call<MealResponse> listMealsByFirstLetter(@Query("f") String letter);

    // 3. Lookup meal details by ID
    @GET("lookup.php")
    Call<MealResponse> lookupMealById(@Query("i") int mealId);

    // 4. Lookup a random meal
    @GET("random.php")
    Call<MealResponse> getRandomMeal();

    // 5. List meal categories
    @GET("categories.php")
    Call<CategoryResponse> getMealCategories();

    // 6. Filter meals by main ingredient
    @GET("filter.php")
    Call<MealResponse> filterMealsByIngredient(@Query("i") String ingredient);

    // 7. Filter meals by category
    @GET("filter.php")
    Call<MealResponse> filterMealsByCategory(@Query("c") String category);

    // 8. Filter meals by area
    @GET("filter.php")
    Call<MealResponse> filterMealsByArea(@Query("a") String area);

    // 9. Get all Areas
    @GET("list.php?a=list")
    Call<MealResponse> listAreas();

}