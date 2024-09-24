package com.example.foodplanner;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodplanner.databinding.ActivityMainBinding;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.MealRemoteDataSource;
import com.example.foodplanner.network.NetworkCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NetworkCallback {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new MealOfTheDayFragment());
        MealRemoteDataSource remote = MealRemoteDataSource.getInstance();
        remote.searchMealByName("Arrabiata",this);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId()==R.id.home){
                replaceFragment(new MealOfTheDayFragment());
            }else if(item.getItemId()==R.id.search){
                replaceFragment(new SearchFragment());
            }else if(item.getItemId()==R.id.favorite){
                replaceFragment(new FavoriteFragment());
            }else if(item.getItemId()==R.id.planner){
                replaceFragment(new WeeklyPlannerFragment());
            }
            return true;
        });


    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
    @Override
    public void onSuccessResult(List<Meal> meals) {
        Toast.makeText(this, "the meal is "+meals.get(0).getMealName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailureResult(String errorMsg) {

    }
}