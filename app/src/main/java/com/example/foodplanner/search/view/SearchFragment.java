package com.example.foodplanner.search.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.db.MealsLocalDataSourceImpl;

import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.MealRemoteDataSource;
import com.example.foodplanner.repository.MealsRepository;
import com.example.foodplanner.search.presenter.SearchPresenter;
import com.example.foodplanner.search.presenter.SearchPresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment implements SearchFragmentView {

    SearchView searchView;
    RecyclerView recyclerViewResults;
    RadioGroup radioGroup;
    RadioButton radioButtonCategory;
    RadioButton radioButtonIngredient;
    RadioButton radioButtonCountry;
    RadioButton radioButtonMealName;
    SearchPresenter presenter;
    int searchType = R.id.radioButtonMealName;
    MealsAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        searchView = view.findViewById(R.id.searchView);
        radioGroup = view.findViewById(R.id.radioGroup);
        radioButtonCategory = view.findViewById(R.id.radioButtonCategory);
        radioButtonIngredient = view.findViewById(R.id.radioButtonIngredient);
        radioButtonCountry = view.findViewById(R.id.radioButtonCountry);
        radioButtonMealName = view.findViewById(R.id.radioButtonMealName);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButtonCategory) {
                    searchType = R.id.radioButtonCategory;
                    Toast.makeText(requireContext(), "Category selected", Toast.LENGTH_SHORT).show();
                } else if (i == R.id.radioButtonIngredient) {
                    searchType = R.id.radioButtonIngredient;
                    Toast.makeText(requireContext(), "Ingredient selected", Toast.LENGTH_SHORT).show();
                } else if (i == R.id.radioButtonCountry) {
                    searchType = R.id.radioButtonCountry;
                    Toast.makeText(requireContext(), "Country selected", Toast.LENGTH_SHORT).show();
                } else if (i == R.id.radioButtonMealName) {
                    searchType = R.id.radioButtonMealName;
                    Toast.makeText(requireContext(), "Meal Name selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        recyclerViewResults = view.findViewById(R.id.recyclerViewResults);
        recyclerViewResults.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewResults.setLayoutManager(layoutManager);

        adapter = new MealsAdapter(requireContext(), new ArrayList<>());
        recyclerViewResults.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                presenter.getMealsResponse(searchType,s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                presenter.getMealsResponse(searchType,s);
                return true;
            }
        });

        presenter = new SearchPresenterImpl(this, MealsRepository.getInstance(
                MealRemoteDataSource.getInstance(),
                MealsLocalDataSourceImpl.getInstance(requireContext())
        ));
        return view;
    }

    @Override
    public void showResults(List<Meal> meals) {
        adapter.setList(meals);  // Update adapter's data
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String errorMsg) {
        Toast.makeText(requireContext(), "Network error : "+errorMsg, Toast.LENGTH_SHORT).show();
    }
}