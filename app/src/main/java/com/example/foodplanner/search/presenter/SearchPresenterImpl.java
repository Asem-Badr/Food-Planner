package com.example.foodplanner.search.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.FilterMealsByAreaCallback;
import com.example.foodplanner.network.FilterMealsByCategoryCallback;
import com.example.foodplanner.network.FilterMealsByIngredientCallback;
import com.example.foodplanner.network.SearchMealByNameCallback;
import com.example.foodplanner.repository.MealsRepository;
import com.example.foodplanner.search.view.SearchFragmentView;

import java.util.List;

public class SearchPresenterImpl implements SearchPresenter, FilterMealsByCategoryCallback,
        FilterMealsByAreaCallback, FilterMealsByIngredientCallback, SearchMealByNameCallback {
    SearchFragmentView view;
    MealsRepository repository;
    private static final String TAG = "Meals presenter ";
    public SearchPresenterImpl(SearchFragmentView view, MealsRepository _repository) {
        this.view = view;
        repository = _repository;
    }


    @Override
    public void getMealsResponse(int searchType, String searchWord) {
        if (searchType == R.id.radioButtonCategory) {
            repository.filterMealsByCategory(searchWord, this);
            Log.i(TAG, "filterMealsByCategory: "+searchWord);
        } else if (searchType == R.id.radioButtonIngredient) {
            repository.filterMealsByIngredient(searchWord, this);
            Log.i(TAG, "filterMealsByIngredient: "+searchWord);
        } else if (searchType == R.id.radioButtonCountry) {
            repository.filterMealsByArea(searchWord, this);
            Log.i(TAG, "filterMealsByArea: "+searchWord);
        } else if (searchType == R.id.radioButtonMealName) {
            repository.searchMealByName(searchWord, this);
            Log.i(TAG, "searchMealByName: "+searchWord);
        }
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
    public void onSuccessFilterByIngredientResult(List<Meal> meals) {
        if (meals != null) {
            view.showResults(meals);
        }
    }

    @Override
    public void onFailureFilterByIngredientResult(String errorMsg) {
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
}
