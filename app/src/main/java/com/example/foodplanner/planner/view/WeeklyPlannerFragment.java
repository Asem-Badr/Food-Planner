package com.example.foodplanner.planner.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.db.MealsLocalDataSourceImpl;
import com.example.foodplanner.favorite.view.MealsAdapter;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.model.PlannedMeal;
import com.example.foodplanner.network.MealRemoteDataSource;
import com.example.foodplanner.planner.presenter.PlanPresenter;
import com.example.foodplanner.planner.presenter.PlanPresenterImpl;
import com.example.foodplanner.repository.MealsRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WeeklyPlannerFragment extends Fragment implements PlanView ,OnRmPlannedClickListener{

    CalendarView calendarView;
    PlanPresenter presenter;
    RecyclerView recyclerViewDayMeals;
    PlannedMealsAdapter adapter;
    long date=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weekly_planner, container, false);
        calendarView = view.findViewById(R.id.calendarView);

        recyclerViewDayMeals = view.findViewById(R.id.recyclerViewDayMeals);
        recyclerViewDayMeals.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewDayMeals.setLayoutManager(layoutManager);
        adapter = new PlannedMealsAdapter(requireContext(), new ArrayList<>(),this);
        recyclerViewDayMeals.setAdapter(adapter);

        presenter = new PlanPresenterImpl(this, MealsRepository.getInstance(
                MealRemoteDataSource.getInstance(),
                MealsLocalDataSourceImpl.getInstance(requireContext())
        ));
        // Preventing selecting past dates
        Calendar calendar = Calendar.getInstance();
        long today = calendar.getTimeInMillis();
        calendarView.setMinDate(today);

        date = getDate((int)calendar.get(Calendar.YEAR), (int)calendar.get(Calendar.MONTH),
                (int)calendar.get(Calendar.DAY_OF_MONTH));
        presenter.getPlannedMeals(date);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                //extract the data associated with the date
                date = getDate(year, month, day);
                presenter.getPlannedMeals(date);
            }
        });
        return view;
    }

    @Override
    public void observeMeals(LiveData<List<PlannedMeal>> plannedMeals) {
        plannedMeals.observe(this, new Observer<List<PlannedMeal>>() {
            @Override
            public void onChanged(List<PlannedMeal> plannedMeals) {
                //Toast.makeText(requireContext(), "Date changed", Toast.LENGTH_SHORT).show();
                adapter.setList(plannedMeals);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showErrMsg(String error) {
        Toast.makeText(requireContext(), "Can't find meals on this day", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onRemovePlannedMealClick(PlannedMeal plannedMeal) {
        presenter.removeFromPlan(plannedMeal);
        Toast.makeText(requireContext(), "Meal removed from plan", Toast.LENGTH_SHORT).show();
    }
}