package com.example.foodplanner.showMeals.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.R;

public class ShowMealsActivity extends AppCompatActivity {

    RecyclerView recyclerViewShowMeals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_meals);
        recyclerViewShowMeals = findViewById(R.id.recyclerViewShowMeals);
    }
}