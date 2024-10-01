package com.example.foodplanner.showMeals.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;
import com.example.foodplanner.db.MealsLocalDataSourceImpl;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.MealRemoteDataSource;
import com.example.foodplanner.repository.MealsRepository;
import com.example.foodplanner.search.presenter.SearchPresenterImpl;
import com.example.foodplanner.search.view.MealsAdapter;
import com.example.foodplanner.showMeals.presenter.MealsPresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class ShowMealsActivity extends AppCompatActivity implements ShowMealsView{

    RecyclerView recyclerViewShowMeals;
    String category;
    String country;
    MealsAdapter adapter;
    MealsPresenterImpl presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_meals);
        recyclerViewShowMeals = findViewById(R.id.recyclerViewShowMeals);

        recyclerViewShowMeals = findViewById(R.id.recyclerViewShowMeals);
        recyclerViewShowMeals.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewShowMeals.setLayoutManager(layoutManager);

        adapter = new MealsAdapter(this, new ArrayList<>());
        recyclerViewShowMeals.setAdapter(adapter);

        Intent intent = getIntent();
        category = intent.getStringExtra("category");
        country = intent.getStringExtra("country");
        presenter = new MealsPresenterImpl(this, MealsRepository.getInstance(
                MealRemoteDataSource.getInstance(),
                MealsLocalDataSourceImpl.getInstance(this)
        ));
        presenter.getMealsResponse(category,country);
    }

    @Override
    public void showResults(List<Meal> meals) {
        adapter.setList(meals);  // Update adapter's data
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String error) {

    }
}