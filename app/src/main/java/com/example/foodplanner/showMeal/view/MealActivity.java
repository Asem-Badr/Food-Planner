package com.example.foodplanner.showMeal.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodplanner.R;
import com.example.foodplanner.db.MealsLocalDataSourceImpl;
import com.example.foodplanner.model.Meal;
import com.example.foodplanner.network.MealRemoteDataSource;
import com.example.foodplanner.repository.MealsRepository;
import com.example.foodplanner.showMeal.presenter.ShowMealPresenter;
import com.example.foodplanner.showMeal.presenter.ShowMealPresenterImpl;

import java.util.ArrayList;

public class MealActivity extends AppCompatActivity implements ShowMealView,OnRmFavoriteClickListener,OnAddFavoriteClickListener{
    ImageView imgMeal;
    TextView txtMealName;
    TextView txtArea;
    TextView txtInstructions;
    WebView webViewVideo;
    Button btnAddToFav;
    Button btnRemoveFromFavMeal;
    RecyclerView recyclerViewIngredients;
    IngredientsAdapter adapter;
    ShowMealPresenter presenter;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meal);
        webViewVideo = findViewById(R.id.webViewVideo);
        imgMeal = findViewById(R.id.imgMeal);
        txtMealName = findViewById(R.id.txtMealName);
        txtArea = findViewById(R.id.txtArea);
        txtInstructions = findViewById(R.id.txtInstructions);
        btnAddToFav = findViewById(R.id.btnAddToFav);
        btnRemoveFromFavMeal = findViewById(R.id.btnRemoveFromFavMeal);
        recyclerViewIngredients = findViewById(R.id.recyclerViewIngredients);
        recyclerViewIngredients.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewIngredients.setLayoutManager(layoutManager);

        WebSettings webSettings = webViewVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);

        presenter = new ShowMealPresenterImpl(this , MealsRepository.getInstance(
                MealRemoteDataSource.getInstance(), MealsLocalDataSourceImpl.getInstance(this)
        ));

        Intent intent = getIntent();
        Meal meal = (Meal) intent.getSerializableExtra("meal");
        if(meal != null){
            Glide.with(this).load(meal.getMealThumbnail()).apply(new RequestOptions()
                            .override(200, 200)
                            .placeholder(R.drawable.baseline_downloading_24)
                            .error(R.drawable.baseline_thumb_down_24))
                    .into(imgMeal);
            txtMealName.setText(meal.getMealName());
            txtArea.setText(meal.getArea());
            txtInstructions.setText(meal.getInstructions());
            String youtubeEmbedUrl = "https://www.youtube.com/embed/" + getYoutubeVideoId(meal.getMealVideo());
            webViewVideo.loadUrl(youtubeEmbedUrl);

            adapter = new IngredientsAdapter(this,meal.getListIngredients(),meal.getListMeasures());
            recyclerViewIngredients.setAdapter(adapter);
            btnAddToFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //presenter add_to_fav() call
                    presenter.addToFav(meal);
                }
            });
            btnRemoveFromFavMeal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //presenter remove_from_favorite() call
                    presenter.removeFromFav(meal);
                }
            });
        }
    }
    //this function contains logic and should be transferred into the presenter
    private String getYoutubeVideoId(String url) {
        String videoId = "";
        if (url != null && url.contains("v=")) {
            String[] parts = url.split("v=");
            videoId = parts[1].split("&")[0];
        }
        return videoId;
    }

    @Override
    public void onAddFavProductClick(Meal meal) {

    }

    @Override
    public void onRmFavProductClick(Meal meal) {

    }
}