package com.example.foodplanner.home.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.foodplanner.MealActivity;
import com.example.foodplanner.db.MealsLocalDataSource;
import com.example.foodplanner.home.view.HomeView;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.GetRandomMealCallback;
import com.example.foodplanner.network.MealRemoteDataSource;

import java.util.List;

public class HomePresenterImpl implements HomePresenter, GetRandomMealCallback {
    private HomeView view;
    private MealRemoteDataSource remoteDataSource;
    private MealsLocalDataSource localDataSource;

    public HomePresenterImpl(HomeView view, MealRemoteDataSource remoteDataSource, MealsLocalDataSource localDataSource) {
        this.view = view;
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    private static final String TAG = "Home Presenter : ";
    @Override
    public void getRandomMeal() {
        remoteDataSource.getRandomMeal(this);
    }

    @Override
    public void addToFav(Meal meal) {
        localDataSource.insertMeal(meal);
    }

    @Override
    public void onSuccessRandomResult(List<Meal> meals) {
        view.showData(meals.get(0));
    }

    @Override
    public void onFailureRandomResult(String errorMsg) {
        view.showErrMsg("couldn't fetch meal of the day ");
    }
}
