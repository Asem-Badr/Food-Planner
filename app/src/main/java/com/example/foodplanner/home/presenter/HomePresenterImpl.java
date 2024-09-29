package com.example.foodplanner.home.presenter;

import com.example.foodplanner.db.MealsLocalDataSource;
import com.example.foodplanner.home.view.HomeView;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.GetRandomMealCallback;
import com.example.foodplanner.network.MealRemoteDataSource;
import com.example.foodplanner.repository.MealsRepository;

import java.util.List;

public class HomePresenterImpl implements HomePresenter, GetRandomMealCallback {
    private HomeView view;
    MealsRepository repository;

    public HomePresenterImpl(HomeView view, MealsRepository _repository) {
        this.view = view;
        repository = _repository;
    }

    private static final String TAG = "Home Presenter : ";
    @Override
    public void getRandomMeal() {
        repository.getRandomMeal(this);
    }

    @Override
    public void addToFav(Meal meal) {
        repository.insertMeal(meal);
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
