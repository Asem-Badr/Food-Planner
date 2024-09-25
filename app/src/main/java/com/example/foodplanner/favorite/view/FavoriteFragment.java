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

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment implements FavView,OnRmFavoriteClickListener{
    FavPresenter favPresenter;
    RecyclerView recyclerViewFav;
    FavMealsAdapter adapter;
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
        adapter = new FavMealsAdapter(requireContext(), new ArrayList<>(),this);
        recyclerViewFav.setAdapter(adapter);

        MealsLocalDataSourceImpl localDataSource = MealsLocalDataSourceImpl.getInstance(requireContext());
        favPresenter = new FavPresenterImpl(this, localDataSource);
        favPresenter.getMeals();
        return view;
    }

    @Override
    public void onRmFavProductClick(Meal meal) {
        favPresenter.removeFromFav(meal);
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