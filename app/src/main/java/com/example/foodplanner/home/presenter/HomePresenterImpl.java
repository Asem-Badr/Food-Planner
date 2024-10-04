package com.example.foodplanner.home.presenter;

import com.example.foodplanner.db.MealsLocalDataSource;
import com.example.foodplanner.home.view.HomeView;
import com.example.foodplanner.model.Category;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.GetMealCategoriesCallback;
import com.example.foodplanner.network.GetRandomMealCallback;
import com.example.foodplanner.network.ListAreasCallBack;
import com.example.foodplanner.network.MealRemoteDataSource;
import com.example.foodplanner.repository.MealsRepository;

import java.util.List;

public class HomePresenterImpl implements HomePresenter, GetRandomMealCallback ,
        GetMealCategoriesCallback , ListAreasCallBack {
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
    public void getCategories() {
        repository.getMealCategories(this);
    }

    @Override
    public void getCountries() {
        repository.listAreas(this);
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

    @Override
    public void onSuccessGetMealCategories(List<Category> categories) {
        view.showCategories(categories);
    }

    @Override
    public void onFailureGetMealCategories(String errorMsg) {
        view.showErrMsg("couldn't fetch categories ");
    }

    @Override
    public void onSuccessListAreasCallBack(List<Meal> countries) {
        view.showCountries(countries);
    }

    @Override
    public void onFailureListAreasCallBack(String errorMsg) {
        view.showErrMsg("couldn't fetch countries ");
    }
}
