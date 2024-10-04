package com.example.foodplanner.planner.presenter;

import androidx.lifecycle.LiveData;


import com.example.foodplanner.model.Meal;
import com.example.foodplanner.model.PlannedMeal;
import com.example.foodplanner.planner.view.PlanView;
import com.example.foodplanner.repository.MealsRepository;

import java.util.List;

public class PlanPresenterImpl implements PlanPresenter {
    MealsRepository repository;
    PlanView view;

    public PlanPresenterImpl(PlanView _view , MealsRepository _repository){
        repository = _repository;
        view = _view;
    }

    @Override
    public void getPlannedMeals(long date) {
        LiveData<List<PlannedMeal>> plannedMealsLiveData = repository.getPlannedMeals(date);
        view.observeMeals(plannedMealsLiveData);
    }

    @Override
    public void removeFromPlan(PlannedMeal meal) {
        repository.deleteFromPlanned(meal);
    }

    @Override
    public void addToPlan(PlannedMeal meal) {
        repository.insertIntoPlanned(meal);
    }
}
