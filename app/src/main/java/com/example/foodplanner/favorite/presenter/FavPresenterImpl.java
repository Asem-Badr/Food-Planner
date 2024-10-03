package com.example.foodplanner.favorite.presenter;

import androidx.lifecycle.LiveData;


import com.example.foodplanner.db.MealsLocalDataSourceImpl;
import com.example.foodplanner.favorite.view.FavView;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.repository.MealsRepository;

import java.util.List;

public class FavPresenterImpl implements FavPresenter {
    MealsRepository repository;
    FavView view;

    public FavPresenterImpl(FavView _view, MealsRepository _repository) {
        repository = _repository;
        view = _view;
    }

    @Override
    public void getMeals() {
        LiveData<List<Meal>> mealsLiveData = repository.getStoredMeals();
        view.observeMeals(mealsLiveData); // Pass LiveData to the view
    }

    @Override
    public void removeFromFav(Meal meal) {
        repository.deleteMeal(meal);
    }
}
