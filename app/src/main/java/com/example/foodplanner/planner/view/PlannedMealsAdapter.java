package com.example.foodplanner.planner.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodplanner.R;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.model.PlannedMeal;
import com.example.foodplanner.showMeal.view.MealActivity;

import java.util.List;

public class PlannedMealsAdapter extends RecyclerView.Adapter<PlannedMealsAdapter.ViewHolder> {
    private final Context context;
    private List<PlannedMeal> values;
    private OnRmPlannedClickListener listener;
    private static final String TAG = "RecyclerViewFav";

    public PlannedMealsAdapter(Context _context, List<PlannedMeal> myDataset, OnRmPlannedClickListener _listener) {
        context = _context;
        values = myDataset;
        listener = _listener;
    }
    public void setList(List<PlannedMeal> _values){
        values = _values;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtTitle;
        public TextView txtDesc;
        public ImageView imgView_thumbnail;
        public ConstraintLayout constraintLayout;
        public View layout;
        public Button btnRemoveFromPlan;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            txtTitle = v.findViewById(R.id.txtIngredient);
            txtDesc = v.findViewById(R.id.txtMeasure);
            imgView_thumbnail = v.findViewById(R.id.imgView_ingredient);
            constraintLayout = v.findViewById(R.id.row);
            btnRemoveFromPlan = v.findViewById(R.id.btnRemoveFromFav);
            btnRemoveFromPlan.setText("Remove From Plan");
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.fav_meal_card, parent, false);
        ViewHolder vh = new ViewHolder(v);
        Log.i(TAG, "onCreateViewHolder: ");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTitle.setText(values.get(position).getMeal().getMealName());
        holder.txtDesc.setText(values.get(position).getMeal().getCategory());
        //holder.imgView_thumbnail.setImageResource(values.get(position).getThumbnail());
        Glide.with(context).load(values.get(position).getMeal().getMealThumbnail()).apply(new RequestOptions()
                        .override(150, 150)
                        .error(R.drawable.baseline_downloading_24))
                .into(holder.imgView_thumbnail);
        holder.btnRemoveFromPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRemovePlannedMealClick(values.get(position));
            }
        });
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MealActivity.class);
                intent.putExtra("meal",values.get(position).getMeal());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
