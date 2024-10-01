package com.example.foodplanner.home.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodplanner.R;
import com.example.foodplanner.model.Category;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.showMeal.view.MealActivity;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    private final Context context;
    private List<Category> values;
    private static final String TAG = "recyclerViewCategories";

    public CategoriesAdapter(Context _context, List<Category> myDataset) {
        context = _context;
        values = myDataset;
    }
    public void setList(List<Category> _values){
        values = _values;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtTitle;
        public TextView txtDesc;
        public ImageView imgView_thumbnail;
        public ConstraintLayout constraintLayout;
        public View layout;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            txtTitle = v.findViewById(R.id.txtIngredient);
            txtDesc = v.findViewById(R.id.txtMeasure);
            imgView_thumbnail = v.findViewById(R.id.imgView_ingredient);
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
        holder.txtTitle.setText(values.get(position).getStrCategory());
        holder.txtDesc.setText(values.get(position).getStrCategoryDescription());
        //holder.imgView_thumbnail.setImageResource(values.get(position).getThumbnail());
        Glide.with(context).load(values.get(position).getStrCategoryThumb()).apply(new RequestOptions()
                        .override(150, 150)
                        .error(R.drawable.baseline_downloading_24))
                .into(holder.imgView_thumbnail);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show the meals of the category in an activity
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
