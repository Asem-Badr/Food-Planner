package com.example.foodplanner.repository;

import androidx.lifecycle.LiveData;

import com.example.foodplanner.db.MealsLocalDataSource;
import com.example.foodplanner.db.MealsLocalDataSourceImpl;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.GetRandomMealCallback;
import com.example.foodplanner.network.MealRemoteDataSource;

import java.util.List;

public class MealsRepository {
    MealRemoteDataSource remoteDataSource;
    MealsLocalDataSource localDataSource;
    private static MealsRepository repo = null;

    public static MealsRepository getInstance(MealRemoteDataSource _remote, MealsLocalDataSource _local){
        if(repo == null){
            return new MealsRepository(_remote,_local);
        }else{
            return repo;
        }
    }
    private MealsRepository(MealRemoteDataSource _remote, MealsLocalDataSource _local){
        remoteDataSource = _remote;
        localDataSource = _local;
    }
    public LiveData<List<Meal>> getStoredMeals(){
        return localDataSource.getAllStoredMeals();
    }
    public void insertMeal(Meal meal){
        localDataSource.insertMeal(meal);
    }
    public void deleteMeal(Meal meal){
        localDataSource.deleteMeal(meal);
    }
    public void getRandomMeal(GetRandomMealCallback getRandomMealCallback){
        remoteDataSource.getRandomMeal(getRandomMealCallback);
    }
}
