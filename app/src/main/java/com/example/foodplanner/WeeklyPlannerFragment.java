package com.example.foodplanner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;

public class WeeklyPlannerFragment extends Fragment {

    CalendarView calendarView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weekly_planner, container, false);
        calendarView = view.findViewById(R.id.calendarView);

        // Preventing selecting past dates
        Calendar calendar = Calendar.getInstance();
        long today = calendar.getTimeInMillis();
        calendarView.setMinDate(today);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Toast.makeText(requireContext(), " "+i2, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}