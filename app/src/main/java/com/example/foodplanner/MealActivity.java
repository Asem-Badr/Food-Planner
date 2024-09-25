package com.example.foodplanner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodplanner.model.Meal;

public class MealActivity extends AppCompatActivity {
    ImageView imgMeal;
    TextView txtMealName;
    TextView txtArea;
    TextView txtInstructions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meal);
        imgMeal = findViewById(R.id.imgMeal);
        txtMealName = findViewById(R.id.txtMealName);
        txtArea = findViewById(R.id.txtArea);
        txtInstructions = findViewById(R.id.txtInstructions);
        Intent intent = getIntent();
        Meal meal = (Meal) intent.getSerializableExtra("meal");
        if(meal != null){
            Glide.with(this).load(meal.getMealThumbnail()).apply(new RequestOptions()
                            .override(200, 200)
                            .placeholder(R.drawable.baseline_downloading_24)
                            .error(R.drawable.baseline_thumb_down_24))
                    .into(imgMeal);
            txtMealName.setText(meal.getMealName());
            txtArea.setText(meal.getArea());
            txtInstructions.setText(meal.getInstructions());
        }
    }
}