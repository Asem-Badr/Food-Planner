package com.example.foodplanner.showMeal.view;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodplanner.R;

import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.ViewHolder> {
    private final Context context;
    private List<String> ingredients;
    private List<String> measures;
    private static final String TAG = "RecyclerViewIngredients : ";

    public IngredientsAdapter(Context _context, List<String> _ingredients, List<String> _measures ) {
        context = _context;
        ingredients = _ingredients;
        measures = _measures;
    }
    public void setList(List<String> _ingredients,List<String> _measures){
        ingredients = _ingredients;
        measures = _measures;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtIngredient;
        public TextView txtMeasure;
        public ImageView imgView_ingredient;
        public ConstraintLayout constraintLayout;
        public View layout;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            txtIngredient = v.findViewById(R.id.txtIngredient);
            txtMeasure = v.findViewById(R.id.txtMeasure);
            imgView_ingredient = v.findViewById(R.id.imgView_ingredient);
            constraintLayout = v.findViewById(R.id.row);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.ingredient_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        Log.i(TAG, "onCreateViewHolder: ");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtIngredient.setText(ingredients.get(position));
        holder.txtMeasure.setText(measures.get(position));
        //holder.imgView_thumbnail.setImageResource(values.get(position).getThumbnail());
        Glide.with(context).load("https://www.themealdb.com/images/ingredients/"
                        + ingredients.get(position)+"-Small.png").apply(new RequestOptions()
                        .override(150, 150)
                        .error(R.drawable.ic_launcher_background))
                .into(holder.imgView_ingredient);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ingredients.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }
}
