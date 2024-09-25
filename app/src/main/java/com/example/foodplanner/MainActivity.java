package com.example.foodplanner;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodplanner.databinding.ActivityMainBinding;
import com.example.foodplanner.db.MealsLocalDataSourceImpl;
import com.example.foodplanner.favorite.view.FavoriteFragment;
import com.example.foodplanner.home.view.MealOfTheDayFragment;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.GetRandomMealCallback;
import com.example.foodplanner.network.MealRemoteDataSource;
import com.example.foodplanner.network.SearchMealByNameCallback;
import com.example.foodplanner.search.SearchFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchMealByNameCallback , GetRandomMealCallback {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new MealOfTheDayFragment());
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
        /* this code is just for testing other features*/
        MealRemoteDataSource remote = MealRemoteDataSource.getInstance();
        remote.searchMealByName("Arrabiata",this);
        remote.getRandomMeal(this);

        MealsLocalDataSourceImpl localDataSource = MealsLocalDataSourceImpl.getInstance(this);
        Meal meal = new Meal(123,"this is the meal name","some category");
        Meal meal2 = new Meal(321,"this is the meal name","some category");
        Meal meal3 = new Meal(231,"this is the meal name","some category");

        localDataSource.insertMeal(meal);
        localDataSource.insertMeal(meal2);
        localDataSource.insertMeal(meal3);
        /* end of this code is just for testing other features*/

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
    @Override
    public void onSuccessResult(List<Meal> meals) {
//        Toast.makeText(this, "the meal is "+meals.get(0).getMealName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailureResult(String errorMsg) {

    }

    @Override
    public void onSuccessRandomResult(List<Meal> meals) {
        //Toast.makeText(this, "the meal is "+meals.get(0).getMealName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailureRandomResult(String errorMsg) {

    }
}