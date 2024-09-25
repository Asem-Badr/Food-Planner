package com.example.foodplanner.favorite.presenter;

import androidx.lifecycle.LiveData;


import com.example.foodplanner.db.MealsLocalDataSourceImpl;
import com.example.foodplanner.favorite.view.FavView;
import com.example.foodplanner.model.Meal;

import java.util.List;

public class FavPresenterImpl implements FavPresenter{
    MealsLocalDataSourceImpl localDataSource;
    FavView view;
    public FavPresenterImpl(FavView _view ,MealsLocalDataSourceImpl _localDataSource){
        localDataSource = _localDataSource;
        view = _view;
    }
    @Override
    public void getMeals() {
        LiveData<List<Meal>> mealsLiveData = localDataSource.getAllStoredMeals();
        view.observeMeals(mealsLiveData); // Pass LiveData to the view
    }


    @Override
    public void removeFromFav(Meal meal) {
        localDataSource.deleteMeal(meal);
    }
}
