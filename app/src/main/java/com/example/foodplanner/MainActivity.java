package com.example.foodplanner;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodplanner.common.Helper;
import com.example.foodplanner.databinding.ActivityMainBinding;
import com.example.foodplanner.db.MealsLocalDataSourceImpl;
import com.example.foodplanner.favorite.view.FavoriteFragment;
import com.example.foodplanner.home.view.MealOfTheDayFragment;
import com.example.foodplanner.planner.view.WeeklyPlannerFragment;
import com.example.foodplanner.search.view.SearchFragment;

public class MainActivity extends AppCompatActivity {

    MealsLocalDataSourceImpl localDataSource;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //replaceFragment(new MealOfTheDayFragment());
        if (!Helper.isNetworkAvailable(this)) {
            showNetworkDialog();  // Show dialog if no network
        } else {
            replaceFragment(new MealOfTheDayFragment());  // Default fragment on start
        }

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

    private void showNetworkDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You are not connected to the internet. Where would you like to go?");

        builder.setPositiveButton("Favorites", (dialog, which) -> {
            replaceFragment(new FavoriteFragment());
            binding.bottomNavigationView.setSelectedItemId(R.id.favorite);
        });

        builder.setNegativeButton("Planner", (dialog, which) -> {
            replaceFragment(new WeeklyPlannerFragment());
            binding.bottomNavigationView.setSelectedItemId(R.id.planner);
        });

        builder.setCancelable(false);  // Prevent dialog from being dismissed by back button
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}