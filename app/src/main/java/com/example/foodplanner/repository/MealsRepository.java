package com.example.foodplanner.repository;

import androidx.lifecycle.LiveData;

import com.example.foodplanner.db.MealsLocalDataSource;
import com.example.foodplanner.db.MealsLocalDataSourceImpl;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.FilterMealsByAreaCallback;
import com.example.foodplanner.network.FilterMealsByCategoryCallback;
import com.example.foodplanner.network.FilterMealsByIngredientCallback;
import com.example.foodplanner.network.GetMealCategoriesCallback;
import com.example.foodplanner.network.GetRandomMealCallback;
import com.example.foodplanner.network.MealRemoteDataSource;
import com.example.foodplanner.network.SearchMealByNameCallback;

import java.util.List;

public class MealsRepository {
    MealRemoteDataSource remoteDataSource;
    MealsLocalDataSource localDataSource;
    private static MealsRepository repo = null;

    public static MealsRepository getInstance(MealRemoteDataSource _remote,
                                              MealsLocalDataSource _local) {
        if (repo == null) {
            return new MealsRepository(_remote, _local);
        } else {
            return repo;
        }
    }

    private MealsRepository(MealRemoteDataSource _remote, MealsLocalDataSource _local) {
        remoteDataSource = _remote;
        localDataSource = _local;
    }

    public LiveData<List<Meal>> getStoredMeals() {
        return localDataSource.getAllStoredMeals();
    }

    public void insertMeal(Meal meal) {
        localDataSource.insertMeal(meal);
    }

    public void deleteMeal(Meal meal) {
        localDataSource.deleteMeal(meal);
    }
    public void searchMealByName(String name, SearchMealByNameCallback searchMealByNameCallback){
        remoteDataSource.searchMealByName(name,searchMealByNameCallback);
    }
    public void getRandomMeal(GetRandomMealCallback getRandomMealCallback) {
        remoteDataSource.getRandomMeal(getRandomMealCallback);
    }

    public void getMealCategories(GetMealCategoriesCallback getMealCategoriesCallback) {
        remoteDataSource.getMealCategories(getMealCategoriesCallback);
    }

    public void filterMealsByIngredient(String ingredient, FilterMealsByIngredientCallback
            filterMealsByIngredientCallback) {
        remoteDataSource.filterMealsByIngredient(ingredient, filterMealsByIngredientCallback);
    }

    public void filterMealsByCategory(String category, FilterMealsByCategoryCallback
            filterMealsByCategoryCallback) {
        remoteDataSource.filterMealsByCategory(category, filterMealsByCategoryCallback);
    }

    public void filterMealsByArea(String area, FilterMealsByAreaCallback filterMealsByAreaCallback) {
        remoteDataSource.filterMealsByArea(area, filterMealsByAreaCallback);
    }

//    public void getCountries(GetCountriesCallBack getCountriesCallBack){
//        remoteDataSource
//    }

}
