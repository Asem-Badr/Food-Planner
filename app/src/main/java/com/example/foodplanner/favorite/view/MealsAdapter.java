package com.example.foodplanner.favorite.view;

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
import com.example.foodplanner.showMeal.view.MealActivity;
import com.example.foodplanner.R;
import com.example.foodplanner.model.Meal;

import java.util.List;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.ViewHolder> {
    private final Context context;
    private List<Meal> values;
    private OnRmFavoriteClickListener listener;
    private static final String TAG = "RecyclerViewFav";

    public MealsAdapter(Context _context, List<Meal> myDataset, OnRmFavoriteClickListener _listener) {
        context = _context;
        values = myDataset;
        listener = _listener;
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
        public Button btnRemoveToFav;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            txtTitle = v.findViewById(R.id.txtIngredient);
            txtDesc = v.findViewById(R.id.txtMeasure);
            imgView_thumbnail = v.findViewById(R.id.imgView_ingredient);
            constraintLayout = v.findViewById(R.id.row);
            btnRemoveToFav = v.findViewById(R.id.btnRemoveFromFav);
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
        holder.txtTitle.setText(values.get(position).getMealName());
        holder.txtDesc.setText(values.get(position).getCategory());
        //holder.imgView_thumbnail.setImageResource(values.get(position).getThumbnail());
        Glide.with(context).load(values.get(position).getMealThumbnail()).apply(new RequestOptions()
                        .override(150, 150)
                        .error(R.drawable.baseline_downloading_24))
                .into(holder.imgView_thumbnail);
        holder.btnRemoveToFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRmFavProductClick(values.get(position));
            }
        });
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
