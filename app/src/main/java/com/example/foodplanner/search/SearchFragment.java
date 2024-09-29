package com.example.foodplanner.search;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.foodplanner.R;

public class SearchFragment extends Fragment {

    Button btnSearchCountry;
    Button btnSearchCategory;
    Button btnSearchIngredient;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

//        btnSearchCountry = view.findViewById(R.id.btnSearchCountry);
//        btnSearchCategory = view.findViewById(R.id.btnSearchCategroy);
//        btnSearchIngredient = view.findViewById(R.id.btnSearchIngredient);
//
//        btnSearchCountry.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //open the search by country activity.
//                Toast.makeText(requireContext(), "opening search by country activity", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        btnSearchCategory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //open the search by country activity.
//                Toast.makeText(requireContext(), "opening search by country activity", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        btnSearchIngredient.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //open the search by country activity.
//                Toast.makeText(requireContext(), "opening search by country activity", Toast.LENGTH_SHORT).show();
//            }
//        });

        return view;
    }
}