package com.example.foodplanner.network;

import com.example.foodplanner.model.Meal;

import java.util.List;

public interface ListAreasCallBack {
    public void onSuccessListAreasCallBack(List<Meal> countries);

    public void onFailureListAreasCallBack(String errorMsg);
}
