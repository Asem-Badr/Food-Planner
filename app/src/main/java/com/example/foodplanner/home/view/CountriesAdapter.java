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
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.showMeal.view.MealActivity;

import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder> {
    private final Context context;
    private List<Meal> values;
    private static final String TAG = "recyclerViewCountries";

    public CountriesAdapter(Context _context, List<Meal> myDataset) {
        context = _context;
        values = myDataset;
    }
    public void setList(List<Meal> _values){
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
        holder.txtTitle.setText(values.get(position).getArea());
        holder.txtDesc.setText(values.get(position).getCategory());
        //holder.imgView_thumbnail.setImageResource(values.get(position).getThumbnail());
        Glide.with(context).load(values.get(position).getMealThumbnail()).apply(new RequestOptions()
                        .override(150, 150)
                        .error(R.drawable.baseline_downloading_24))
                .into(holder.imgView_thumbnail);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MealActivity.class);
                intent.putExtra("meal",values.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
