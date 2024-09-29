package com.example.foodplanner.showMeal.presenter;

import androidx.lifecycle.LiveData;

import com.example.foodplanner.favorite.presenter.FavPresenter;
import com.example.foodplanner.favorite.view.FavView;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.repository.MealsRepository;
import com.example.foodplanner.showMeal.view.ShowMealView;

import java.util.List;

public class ShowMealPresenterImpl implements ShowMealPresenter {
    MealsRepository repository;
    ShowMealView view;

    public ShowMealPresenterImpl(ShowMealView _view, MealsRepository _repository) {
        repository = _repository;
        view = _view;
    }

    @Override
    public void addToFav(Meal meal) {
        repository.insertMeal(meal);
    }

    @Override
    public void removeFromFav(Meal meal) {
        repository.deleteMeal(meal);
    }
}
