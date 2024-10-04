package com.example.foodplanner.favorite.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.R;
import com.example.foodplanner.db.MealsLocalDataSourceImpl;
import com.example.foodplanner.favorite.presenter.FavPresenter;
import com.example.foodplanner.favorite.presenter.FavPresenterImpl;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.MealRemoteDataSource;
import com.example.foodplanner.repository.MealsRepository;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment implements FavView, OnRmFavoriteClickListener {
    FavPresenter favPresenter;
    RecyclerView recyclerViewFav;
    MealsAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        recyclerViewFav = view.findViewById(R.id.recyclerViewFav);
        recyclerViewFav.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewFav.setLayoutManager(layoutManager);
        adapter = new MealsAdapter(requireContext(), new ArrayList<>(), this);
        recyclerViewFav.setAdapter(adapter);

        //for the mvp design the view shouldn't contain any reference to the data sources.

        favPresenter = new FavPresenterImpl(this, MealsRepository.getInstance(
                MealRemoteDataSource.getInstance(),
                MealsLocalDataSourceImpl.getInstance(requireContext())
        ));
        favPresenter.getMeals();
        return view;
    }

    @Override
    public void onRmFavProductClick(Meal meal) {
        favPresenter.removeFromFav(meal);
        Snackbar snackbar = Snackbar.make(recyclerViewFav, "Remove " +
                        meal.getMealName() + " from favorites?", Snackbar.LENGTH_LONG);
        snackbar.setAction("undo", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favPresenter.addToFav(meal);
            }
        });
        snackbar.show();
    }

    @Override
    public void observeMeals(LiveData<List<Meal>> liveData) {
        liveData.observe(this, new Observer<List<Meal>>() {
            @Override
            public void onChanged(List<Meal> meals) {
                Log.i("Fav data Change", "onChanged: " + meals.size());
                adapter.setList(meals);  // Update adapter's data
                adapter.notifyDataSetChanged();  // Notify adapter about the changes
            }
        });
    }

    @Override
    public void showErrMsg(String error) {

    }
}