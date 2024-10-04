package com.example.foodplanner;

import android.content.Intent;
import android.os.Bundle;
import android.animation.Animator;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.example.foodplanner.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Load the Lottie animation
        LottieAnimationView lottieAnimationView = binding.lottieAnimationView;
        lottieAnimationView.setAnimation(R.raw.animation); // Replace with your Lottie animation file name
        lottieAnimationView.playAnimation();

        // After the animation ends, start MainActivity
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish(); // Close SplashActivity
            }

            @Override
            public void onAnimationStart(Animator animation) {}
            @Override
            public void onAnimationCancel(Animator animation) {}
            @Override
            public void onAnimationRepeat(Animator animation) {}
        });
    }
}
