package com.example.foodplanner.showMeals.presenter;

import android.util.Log;

import com.example.foodplanner.R;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.FilterMealsByAreaCallback;
import com.example.foodplanner.network.FilterMealsByCategoryCallback;
import com.example.foodplanner.network.FilterMealsByIngredientCallback;
import com.example.foodplanner.network.SearchMealByNameCallback;
import com.example.foodplanner.repository.MealsRepository;
import com.example.foodplanner.search.presenter.SearchPresenter;
import com.example.foodplanner.search.view.SearchFragmentView;
import com.example.foodplanner.showMeals.view.ShowMealsView;

import java.util.List;

public class MealsPresenterImpl implements  FilterMealsByCategoryCallback,
       SearchMealByNameCallback ,FilterMealsByAreaCallback{
    ShowMealsView view;
    MealsRepository repository;
    private static final String TAG = "Meals presenter ";
    public MealsPresenterImpl(ShowMealsView view, MealsRepository _repository) {
        this.view = view;
        repository = _repository;
    }


    public void getMealsResponse(String searchWordCategory, String searchWordCountry) {
        if(searchWordCategory != null) {
            repository.filterMealsByCategory(searchWordCategory, this);
        }else{
            repository.filterMealsByArea(searchWordCountry,this);
        }
    }

    @Override
    public void onSuccessFilterByCategoryResult(List<Meal> meals) {
        if (meals != null) {
            view.showResults(meals);
        }
    }

    @Override
    public void onFailureFilterByCategoryResult(String errorMsg) {
        view.showErrorMessage(errorMsg);
    }


    @Override
    public void onSuccessResult(List<Meal> meals) {
        if (meals != null) {
            view.showResults(meals);
        }
    }

    @Override
    public void onFailureResult(String errorMsg) {
        view.showErrorMessage(errorMsg);
    }

    @Override
    public void onSuccessFilterByAreaResult(List<Meal> meals) {
        if (meals != null) {
            view.showResults(meals);
        }
    }

    @Override
    public void onFailureFilterByAreaResult(String errorMsg) {
        view.showErrorMessage(errorMsg);
    }
}
