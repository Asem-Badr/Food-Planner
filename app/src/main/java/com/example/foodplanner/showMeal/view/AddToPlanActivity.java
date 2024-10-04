package com.example.foodplanner.showMeal.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodplanner.R;
import com.example.foodplanner.db.MealsLocalDataSourceImpl;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.model.PlannedMeal;
import com.example.foodplanner.network.MealRemoteDataSource;
import com.example.foodplanner.repository.MealsRepository;

import java.util.Calendar;

public class AddToPlanActivity extends AppCompatActivity {

    PlannedMeal plannedMeal = null;
    CalendarView calendarViewAdd;
    Button btnAddMeal;
    MealsRepository repository;
    long date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_to_plan);
        calendarViewAdd = findViewById(R.id.calendarViewAdd);
        btnAddMeal = findViewById(R.id.btnAddMeal);
        Calendar calendar = Calendar.getInstance();

        long today = calendar.getTimeInMillis();
        calendarViewAdd.setMinDate(today);

        date = getDate((int)calendar.get(Calendar.YEAR), (int)calendar.get(Calendar.MONTH),
                (int)calendar.get(Calendar.DAY_OF_MONTH));

        Intent intent = getIntent();
        Meal meal = (Meal) intent.getSerializableExtra("meal");
        plannedMeal = new PlannedMeal(meal,date);

        repository = MealsRepository.getInstance(
                MealRemoteDataSource.getInstance(),
                MealsLocalDataSourceImpl.getInstance(AddToPlanActivity.this));


        calendarViewAdd.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                date = getDate(year, month, day);
                plannedMeal.setDate(date);
            }
        });
        btnAddMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(plannedMeal == null){
                    Toast.makeText(AddToPlanActivity.this, "choose the day pls ", Toast.LENGTH_SHORT).show();
                }else{
                    repository.insertIntoPlanned(plannedMeal);
                }
            }
        });
    }
    public long getDate(int year, int month, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);  // Set the desired date
        calendar.clear(Calendar.HOUR_OF_DAY);   // Clear hour (sets it to 0)
        calendar.clear(Calendar.MINUTE);        // Clear minute
        calendar.clear(Calendar.SECOND);        // Clear second
        calendar.clear(Calendar.MILLISECOND);
        return calendar.getTimeInMillis();
    }
}