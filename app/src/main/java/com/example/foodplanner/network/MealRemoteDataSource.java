package com.example.foodplanner.network;

import android.util.Log;

import com.example.foodplanner.model.CategoryResponse;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.model.MealResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealRemoteDataSource {
    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private MealService service;
    private String TAG = "retrofit";

    private static MealRemoteDataSource retrofit = null;

    public static MealRemoteDataSource getInstance() {
        if (retrofit == null) {
            retrofit = new MealRemoteDataSource();
            return retrofit;
        } else {
            return retrofit;
        }
    }

    private MealRemoteDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(MealService.class);
    }

    public void searchMealByName(String name, SearchMealByNameCallback searchMealByNameCallback) {
        service.searchMealByName(name).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                searchMealByNameCallback.onSuccessResult(response.body().getMeals());
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable throwable) {
                Log.i(TAG, "onFailure: ");
            }
        });

    }

    public void getRandomMeal(GetRandomMealCallback getRandomMealCallback) {
        service.getRandomMeal().enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                getRandomMealCallback.onSuccessRandomResult(response.body().getMeals());
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable throwable) {
                getRandomMealCallback.onFailureRandomResult("couldn't fetch a random meal ");
            }
        });
    }

    public void getMealCategories(GetMealCategoriesCallback getMealCategoriesCallback) {
        service.getMealCategories().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                getMealCategoriesCallback.onSuccessGetMealCategories(response.body().getCategories());
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable throwable) {
                getMealCategoriesCallback.onFailureGetMealCategories("couldn't fetch categories");
            }
        });
    }

    public void filterMealsByIngredient(String ingredient, FilterMealsByIngredientCallback
            filterMealsByIngredientCallback) {
        service.filterMealsByIngredient(ingredient).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                filterMealsByIngredientCallback.onSuccessFilterByIngredientResult(response.body().getMeals());
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable throwable) {
                filterMealsByIngredientCallback.onFailureFilterByIngredientResult("couldn't filter by ingredient");
            }
        });
    }

    public void filterMealsByCategory(String category, FilterMealsByCategoryCallback filterMealsByCategoryCallback) {
        service.filterMealsByCategory(category).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                filterMealsByCategoryCallback.onSuccessFilterByCategoryResult(response.body().getMeals());
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable throwable) {
                filterMealsByCategoryCallback.onFailureFilterByCategoryResult("couldn't filter by category ");
            }
        });
    }

    public void filterMealsByArea(String area, FilterMealsByAreaCallback filterMealsByAreaCallback) {
        service.filterMealsByArea(area).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                filterMealsByAreaCallback.onSuccessFilterByAreaResult(response.body().getMeals());
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable throwable) {
                filterMealsByAreaCallback.onFailureFilterByAreaResult("couldn't filter by Area ");
            }
        });
    }
//    public void getCountries(GetCountriesCallBack getCountriesCallBack){
//        service.
//    }
}
