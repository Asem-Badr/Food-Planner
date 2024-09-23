package com.example.foodplanner.network;

import android.util.Log;

import com.example.foodplanner.model.Meal;
import com.example.foodplanner.model.MealResponse;

import java.util.ArrayList;
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

    public static MealRemoteDataSource getInstance(){
        if(retrofit == null){
            retrofit = new MealRemoteDataSource();
            return retrofit;
        }
        else{
            return retrofit;
        }
    }

    private MealRemoteDataSource(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(MealService.class);
    }
    public void searchMealByName(String name , NetworkCallback networkCallback){
        List<Meal> result;
        service.searchMealByName(name).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                networkCallback.onSuccessResult(response.body().getMeals());
                Log.i(TAG, "onResponse: "+response.body().getMeals().size());
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable throwable) {
                Log.i(TAG, "onFailure: ");
            }
        });
        
    }
}
