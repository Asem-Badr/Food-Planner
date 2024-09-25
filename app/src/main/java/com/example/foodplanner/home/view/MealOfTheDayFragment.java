package com.example.foodplanner.home.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodplanner.MealActivity;
import com.example.foodplanner.R;
import com.example.foodplanner.db.MealsLocalDataSourceImpl;
import com.example.foodplanner.home.presenter.HomePresenter;
import com.example.foodplanner.home.presenter.HomePresenterImpl;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.MealRemoteDataSource;

public class MealOfTheDayFragment extends Fragment implements HomeView {
    ImageView imgViewThumbnail;
    TextView txtViewMealTitle;
    CardView cardMeal;
    HomePresenter presenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_of_the_day, container, false);
        MealsLocalDataSourceImpl localDataSource = MealsLocalDataSourceImpl.getInstance(requireContext());
        MealRemoteDataSource remoteDataSource = MealRemoteDataSource.getInstance();
        presenter = new HomePresenterImpl(this,remoteDataSource,localDataSource);

        imgViewThumbnail = view.findViewById(R.id.imgViewThumbnail);
        txtViewMealTitle = view.findViewById(R.id.txtViewMealTitle);
        cardMeal = view.findViewById(R.id.cardMeal);
        presenter.getRandomMeal();

        return view;
    }

    @Override
    public void showData(Meal meal) {
        if(isAdded()) {
            Toast.makeText(requireContext(), meal.getMealName(), Toast.LENGTH_SHORT).show();
            Glide.with(requireContext()).load(meal.getMealThumbnail()).apply(new RequestOptions()
                            .override(200, 200)
                            .placeholder(R.drawable.baseline_downloading_24)
                            .error(R.drawable.baseline_thumb_down_24))
                    .into(imgViewThumbnail);
            txtViewMealTitle.setText(meal.getMealName());
            cardMeal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(requireContext(), MealActivity.class);
                    intent.putExtra("meal",meal);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void showErrMsg(String error) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show();
    }

}